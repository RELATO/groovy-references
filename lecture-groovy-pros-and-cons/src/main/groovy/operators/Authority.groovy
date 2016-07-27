package operators

class Authority {
    def roles = []

    Authority() {
    }

    Authority(roles) {
        this.roles = roles
    }

    Authority plus(Role role) {
        new Authority(roles + role)
    }

    Authority minus(Role role) {
        new Authority(roles - role)
    }

    Authority plus(Authority authority) {
        new Authority(roles + authority.roles)
    }

    Authority minus(Authority authority) {
        new Authority(roles - authority.roles)
    }

    @Override
    public String toString() {
        return "(${roles.collect { Role role -> role.name() }.join(",")})";
    }
}
