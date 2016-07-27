import fidercontactrules.Rules

// Place your Spring DSL code here
beans = {
    rules(Rules) {
        deltaAge = 5
        deltaHeight = 0.1
    }
}
