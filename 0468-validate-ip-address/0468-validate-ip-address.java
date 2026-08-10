class Solution {

    public String validIPAddress(String queryIP) {

        if (queryIP.contains(".")) {

            if (isIPv4(queryIP)) {
                return "IPv4";
            }

        } else if (queryIP.contains(":")) {

            if (isIPv6(queryIP)) {
                return "IPv6";
            }
        }

        return "Neither";
    }

    private boolean isIPv4(String ip) {

        String[] parts = ip.split("\\.", -1);

        // IPv4 must have exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {

            // Empty part
            if (part.length() == 0) {
                return false;
            }

            // Leading zero
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            // Maximum 3 digits
            if (part.length() > 3) {
                return false;
            }

            int num = 0;

            for (char c : part.toCharArray()) {

                // Only digits
                if (!Character.isDigit(c)) {
                    return false;
                }

                num = num * 10 + (c - '0');
            }

            // Range: 0 - 255
            if (num > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv6(String ip) {

        String[] parts = ip.split(":", -1);

        // IPv6 must have exactly 8 parts
        if (parts.length != 8) {
            return false;
        }

        for (String part : parts) {

            // Length must be 1 to 4
            if (part.length() < 1 || part.length() > 4) {
                return false;
            }

            for (char c : part.toCharArray()) {

                if (!isHex(c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isHex(char c) {

        return (c >= '0' && c <= '9') ||
               (c >= 'a' && c <= 'f') ||
               (c >= 'A' && c <= 'F');
    }
}