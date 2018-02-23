package transformer

def resourcesDirectory = './../../resources/'

def columns = new ArrayList()
columns.add(new Column('Apple', 6, 1))
columns.add(new Column('Banana', 2, 2))
columns.add(new Column('Carrot', 5, 2))

def recordGenerator = new RecordGenerator(columns)

def textGenerator = new TextGenerator("${ resourcesDirectory }Data1.txt", recordGenerator)
textGenerator.generateFile()

def input = new FileReader("${ resourcesDirectory }lines.txt")
input.run()
