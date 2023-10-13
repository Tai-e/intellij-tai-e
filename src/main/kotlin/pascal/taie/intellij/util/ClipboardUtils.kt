package pascal.taie.intellij.util

import com.intellij.openapi.ide.CopyPasteManager
import java.awt.datatransfer.StringSelection

object ClipboardUtils {

    fun setContent(content: String) {
        CopyPasteManager.getInstance().setContents(StringSelection(content))
    }
}