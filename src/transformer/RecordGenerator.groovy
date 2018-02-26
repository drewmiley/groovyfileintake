package transformer

class RecordGenerator {

    private List<Column> columns

    RecordGenerator(List<Column> columns = null) {
        this.columns = columns
    }

    String genericString() {
        Math.random() > 0.95 ? 'Dumb Luck' : 'Some Text'
    }

    String newRecord(int i) {
        String record = ''
        String text = genericString()
        columns.each {
            record += "${ i }${ text }".substring(0, it.length)
            (1..it.padding).each { record += ' '}
        }
        record
    }
}
