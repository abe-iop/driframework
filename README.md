# Dr. Inventor Text Mining Framework
*Dr. Inventor Text Mining Framework, a Java library to bootstrap the analysis of scientific publications*


Dr. Inventor Text Mining Framework is a Java library that integrates several Document Engeneering and Natural Language Processing tools customized to enable and ease the analysis of the textual contents of scientific publications.
Dr. Inventor Text Mining Framework is a standalone Java library that enable users to process the contents of papers both in PDF and JATS XML format. Once imported a paper from a local file or a remote URL, the Framework automatically extracts and characterizes several aspects including:
* Structural elements: title, abstract, hierarchy of sections, sentences inside each section, bibliographic entries
* Bibliographic entries are parsed and enriched by accessing external web services (Bibsonomy, CrossRef, FreeCite, Google Scholar)
* Inline citations are spotted and linked to the respective bibliographic entry
* The dependency tree is built from each sentence by considering inline citations
* The discoursive category of each sentence is identified among: Background, Challenge, Approach, Outcome and Future Work
* BabelNet synsets are spotted inside the contents of each sentence thanks to Babelfy
* Subject-Verb-Object graphs are build to represent the contents of paper excerpts (the connectedness of these graphs is enhanced thanks to coreference resolution)
* Relevant sentences are selected with respect to several criteria to build extractive summaries of a paper
* etc.

All these facets of a paper are automatically mined and can be easily accessed thanks to the set of method and classes defined by the Dr. Inventor Text Mining Framework.
