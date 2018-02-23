package transformer

def resourcesDirectory = './../../resources/'

def textGenerator = new TextGenerator("${ resourcesDirectory }Data1.txt")
textGenerator.generateFile()

def input = new FileReader("${ resourcesDirectory }lines.txt")
input.run()
