package transformer

class FileComparator {

    private List<String> left

    private List<String> right

    private String matchColumnName

    FileComparator(List<String> left, List<String> right, String matchColumnName) {
        this.left = left
        this.right = right
        this.matchColumnName = matchColumnName
    }

    List<String> common() {
        null
    }

    List<String> deltaLeft() {
        null
    }

    List<String> deltaRight() {
        null
    }
}
