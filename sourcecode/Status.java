/**
 * Enumeration representing the status of a book.
 */
public enum Status {
        /**
        * Status indicating that the book is available for borrowing.
        * Overrides the toString() method to return "Available".
        */
        AVAILABLE {
            @Override
            public String toString() {
                return "Available";
            }
        },

        /**
        * Status indicating that the book has been checked out by a patron.
        * Overrides the toString() method to return "Checked Out".
        */
        CHECKED_OUT {
            @Override
            public String toString() {
                return "Checked Out";
            }
        },

        /**
        * Status indicating that the book is overdue and has not been returned within the grace period.
        * Overrides the toString() method to return "Overdue".
        */
        OVERDUE {
            @Override
            public String toString() {
                return "Overdue";
            }
        };
}
