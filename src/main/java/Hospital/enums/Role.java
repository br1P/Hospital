package Hospital.enums;

public enum Role {
    RECEPTIONIST("Handles appointments and front desk", 1),
    CLEANING_STAFF("Maintains cleanliness", 2),
    MAINTENANCE("Repairs and maintains facilities", 3),
    SECURITY("Ensures people's safety", 4),
    ADMINISTRATIVE("Manages  admin tasks", 5);

    private final String description;
    private final int level;


    Role(String description, int level) {
        this.description = description;
        this.level = level;
    }


    public String getDescription() {
        return description;
    }


    public int getLevel() {
        return level;
    }


    public boolean isEssential() {
        return this == SECURITY || this == MAINTENANCE;
    } //check for essentials roles

    // Block to execute specific code for each enum value
    static {
        for (Role role : Role.values()) {
            System.out.println(role + ": " + role.getDescription() + " (Level " + role.getLevel() + ")");
        }
    }
}