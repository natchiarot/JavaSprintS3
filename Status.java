public enum Status {
        AVAILABLE {
            @Override
            public String toString() {
                return "Available";
            }
        },
        CHECKED_OUT {
            @Override
            public String toString() {
                return "Checked Out";
            }
        },
        OVERDUE {
            @Override
            public String toString() {
                return "Overdue";
            }
        };
}
