package transformer

class RecordGenerator {

    private List<Column> columns

    RecordGenerator(List<Column> columns = null) {
        this.columns = columns
    }

    String newRecord() {
        'Some Text'
    }
}
