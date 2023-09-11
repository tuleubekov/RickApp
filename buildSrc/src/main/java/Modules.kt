object Modules {

    const val data = ":data"
    const val domain = ":domain"

    object Common {
        const val ui = ":common:ui"
        const val utils = ":common:utils"
    }
    object Core {
        const val di = ":core:di"
        const val network = ":core:network"
        const val navApi = ":core:navigation:api"
        const val navImpl = ":core:navigation:impl"
        const val presentation = ":core:presentation"
    }

    object Features {
        const val splash = ":features:splash"
        const val home = ":features:home"
        const val details = ":features:details"
        const val search = ":features:search"
    }
}