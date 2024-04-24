package pascal.taie.intellij.tir.syntax

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import pascal.taie.intellij.tir.highlight.TirSyntaxHighlighter
import pascal.taie.intellij.tir.syntax.psi.*

class TirAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is TirAnnotationDefName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(TirSyntaxHighlighter.ANNOTATION)
                    .create()
            }

            is TirIdentifierType -> {
                if (element.parent !is TirIdentifierField) {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(element.textRange)
                        .textAttributes(TirSyntaxHighlighter.TYPE)
                        .create()
                }
            }

            is TirIdentifierField, is TirFieldSig -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(TirSyntaxHighlighter.INSTANCE_FIELD)
                    .create()
            }

            is TirIdentifierMethod, is TirInvokeMethodRef -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(TirSyntaxHighlighter.INSTANCE_METHOD)
                    .create()
            }

            is TirIdentifierVariable -> {
                if (element.text == "%this") {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(element.textRange)
                        .textAttributes(TirSyntaxHighlighter.PARAMETER)
                        .create()
                }
            }
        }
    }
}