package transformer

class FileComparator {

    private List<String> left

    private List<String> right

    private String matchColumnName

    List<Column> columns

    FileComparator(List<String> left, List<String> right, String matchColumnName = null, List<Column> columns = null) {
        this.left = left
        this.right = right
    }

    List<String> common() {
        List<String> common = new ArrayList<String>()
        left.each {
            if (right.contains(it)) {
                common << it
            }
        }
        common
    }

    List<String> deltaLeft() {
        List<String> deltaLeft = new ArrayList<String>()
        left.each {
            if (!right.contains(it)) {
                deltaLeft << it
            }
        }
        deltaLeft
    }

    List<String> deltaRight() {
        List<String> deltaRight = new ArrayList<String>()
        right.each {
            if (!left.contains(it)) {
                deltaRight << it
            }
        }
        deltaRight
    }
}
