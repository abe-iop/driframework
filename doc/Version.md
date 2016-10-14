# Library versions

**Latest version: 2.3, released on: 10/10/2016**

## New features of library versions

### New features of version 2.3:
* New, improved ROS generation methods: it is possible to generate a ROS from a paper (or an excerpt of it) by relying on the new pair of complementary methods: getDocumentROSasCSVstring and getSentencesCSVstring. The first method is useful to get the ROD graph of a document, the second method is useful to get the contents and metadata concerning the sentences of the same document. The new ROS includes the following improvements / additions:
  * CUSE relations, besides SUBJECT and OBJECT ones (links a cause node to the corresponding effect node);
  * nodes belonging to the same coreference chains are merged;
  * node names improved (including multiword expressions).
To get detailed information, please, access the javadoc of the ROS generation complementary methods: getDocumentROSasCSVstring and getSentencesCSVstring.
* Possibility to parse plain text excerpts: it is possible to parse a text excerpt and load it in a Document by means of the following command:
Document edu.upf.taln.dri.lib.model newDocument =
edu.upf.taln.dri.lib.Factory.getPlainTextLoader().parseString(
java.lang.String textToLoad, java.lang.String docName)
method; the textToLoad parameter is the text excerpt to parse, while the docName parameter is the document name that is optiona and can be set also as null. See the Javadoc at: parseString.
* Improved model for rhetorical sentence classification
* Library maintenance