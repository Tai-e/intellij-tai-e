package pascal.taie.intellij.util

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassInitializer
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiType
import com.intellij.psi.PsiTypeParameter
import com.intellij.psi.impl.source.PsiClassReferenceType
import com.intellij.psi.util.ClassUtil

object PsiUtils {

    fun toTirClassName(clz: PsiClass): String? {
        val clzName = ClassUtil.getJVMClassName(clz) ?: return null
        return "<$clzName>"
    }

    fun toTirFieldSignature(field: PsiField): String? {
        val clzName = ClassUtil.getJVMClassName(field.containingClass!!) ?: return null
        val typeName = getGenericFreeType(field.type)
        return "<$clzName: $typeName ${field.name}>"
    }

    fun toTirMethodSignature(method: PsiMethod): String? {
        val clzName = ClassUtil.getJVMClassName(method.containingClass!!) ?: return null
        val returnType = getGenericFreeType(method.returnType)

        val signature = StringBuilder()
        signature.append("<")
        signature.append(clzName)
        signature.append(": ")
        signature.append(returnType)
        signature.append(" ")
        signature.append(getMethodName(method))
        signature.append("(")
        method.parameterList.parameters.forEachIndexed { index, parameter ->
            if (index != 0) {
                signature.append(",")
            }
            signature.append(getGenericFreeType(parameter.type))
        }
        signature.append(")>")
        return signature.toString()
    }

    fun toTirMethodSignature(method: PsiClassInitializer): String? {
        val clzName = ClassUtil.getJVMClassName(method.containingClass!!) ?: return null
        return "<$clzName: void <clinit>()>"
    }

    private fun getMethodName(method: PsiMethod): String {
        if (method.isConstructor) {
            return "<init>"
        }
        return method.name
    }

    /**
     * currently generic type is not support
     */
    private fun getGenericFreeType(type: PsiType?): String {
        if (type == null) {
            return "void"
        }

        if (type is PsiClassReferenceType && type.reference.resolve() is PsiTypeParameter) {
            return "java.lang.Object"
        }

        val typeText = type.canonicalText
        val index = typeText.indexOf("<")
        if (index != -1) {
            return typeText.substring(0, index)
        }

        return typeText
    }
}
