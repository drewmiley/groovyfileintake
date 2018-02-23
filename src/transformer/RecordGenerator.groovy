package transformer

class RecordGenerator {

    private List<Column> columns

    RecordGenerator(List<Column> columns = null) {
        this.columns = columns
    }

    String genericString() {
        'Some Text'
    }

    String newRecord() {
        String record = ''
        columns.each {
            record += genericString().substring(0, it.length)
            (1..it.padding).each { record += ' '}
        }
        record
    }
}
