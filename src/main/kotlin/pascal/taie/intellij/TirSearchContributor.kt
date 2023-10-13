package pascal.taie.intellij

import com.intellij.ide.actions.searcheverywhere.FoundItemDescriptor
import com.intellij.ide.actions.searcheverywhere.SearchEverywhereContributor
import com.intellij.ide.actions.searcheverywhere.SearchEverywhereContributorFactory
import com.intellij.ide.actions.searcheverywhere.SymbolSearchEverywhereContributor
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.util.Processor
import pascal.taie.intellij.util.TirPatternFilter

class TirSearchContributor(event: AnActionEvent) : SymbolSearchEverywhereContributor(event) {

    override fun getGroupName(): String = "Tai-e IR"

    override fun fetchWeightedElements(
        rawPattern: String,
        progressIndicator: ProgressIndicator,
        consumer: Processor<in FoundItemDescriptor<Any>>
    ) {
        super.fetchWeightedElements(TirPatternFilter.applyPatternReBuild(rawPattern), progressIndicator, consumer)
    }

    class Factory : SearchEverywhereContributorFactory<Any> {
        override fun createContributor(initEvent: AnActionEvent): SearchEverywhereContributor<Any> {
            return TirSearchContributor(initEvent)
        }
    }
}
