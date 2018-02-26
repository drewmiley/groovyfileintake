package transformer

class RecordGeneratorTest extends GroovyTestCase {

    private RecordGenerator recordGenerator

    void setUp() {
        recordGenerator = new RecordGenerator()
    }

    void tearDown() {
        recordGenerator = null
    }

    void testNewRecord() {
        assert recordGenerator.newRecord(0) == ''
    }

    void testNewRecordWithColumns() {
        List<Column> columns = new ArrayList()
        columns.add(new Column('Apple', 6, 1))
        columns.add(new Column('Banana', 2, 2))
        columns.add(new Column('Carrot', 5, 2))

        recordGenerator = new RecordGenerator(columns)

        (0..9).each {
            String record = recordGenerator.newRecord(it)
            assert (record == "${it}Some  ${it}S  ${it}Some  " || record == "${it}Dumb  ${it}D  ${it}Dumb  ")
        }

        (10..99).each {
            String record = recordGenerator.newRecord(it)
            assert (record == "${it}Some ${it}  ${it}Som  " || record == "${it}Dumb ${it}  ${it}Dum  ")
        }
    }
}
