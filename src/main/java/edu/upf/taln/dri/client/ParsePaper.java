package edu.upf.taln.dri.client;

import java.util.List;

import edu.upf.taln.dri.lib.Factory;
import edu.upf.taln.dri.lib.exception.DRIexception;
import edu.upf.taln.dri.lib.model.Document;
import edu.upf.taln.dri.lib.model.ext.Citation;
import edu.upf.taln.dri.lib.model.ext.Section;
import edu.upf.taln.dri.lib.model.ext.Sentence;
import edu.upf.taln.dri.lib.model.ext.SentenceSelectorENUM;
import edu.upf.taln.dri.lib.model.ext.SummaryTypeENUM;
import edu.upf.taln.dri.lib.model.graph.DependencyGraph;
import edu.upf.taln.dri.lib.util.PDFtoTextConvMethod;


/**
 * This class shows how to import a scientific publication in the
 * Dr. Inventor Text Mining Framework.
 * @author Francesco Ronzano
 *
 */
public class ParsePaper {

	public static void main(String[] args) {

		// 1) Set the property folder
		Factory.setDRIPropertyFilePath("/home/francesco/Desktop/DRILIB_EXP/DRIconfig.properties");

		// 2) Programmatically configure the PDF processing options 
		Factory.setPDFtoTextConverter(PDFtoTextConvMethod.GROBID);
		Factory.setEnableBibEntryParsing(true);

		// 3) Initialize the library - preload the resources needed to process scientific publications
		try {
			Factory.initFramework();
		} catch (DRIexception e) {
			System.out.println("Error while initializing the Dr. Inventor Text Mining Framework!");
			e.printStackTrace();
		}

		// 4) Load PDF from local file
		Document doc_PDFpaperFILE = null;
		try {
			String PDF_FILE_PATH = "/home/francesco/Downloads/paper_PUBMED_1.pdf";
			doc_PDFpaperFILE = Factory.getPDFloader().parsePDF(PDF_FILE_PATH);
		} catch (DRIexception e) {
			System.out.println("Error while importing a PDF file in the Dr. Inventor Text Mining Framework!");
			e.printStackTrace();
		}

		// 5) Pre-process PDF file
		try {
			doc_PDFpaperFILE.preprocess();
		} catch (DRIexception e) {
			System.out.println("Error while preprocessing a PDF file by means of the Dr. Inventor Text Mining Framework!");
			e.printStackTrace();
		}

		try {
			// 6) Extract abstract sentences from a Dr. Inventor Document (ordered)
			List<Sentence> abstract_SentList = doc_PDFpaperFILE.extractSentences(SentenceSelectorENUM.ONLY_ABSTRACT);
			for(Sentence abstract_Sent : abstract_SentList) {
				System.out.println("ABSTRACT SENTENCE > " + abstract_Sent.asString(true));
			}

			// 7) Extract abstract sentences from a Dr. Inventor Document (ordered)
			List<Citation> citsList = doc_PDFpaperFILE.extractCitations();
			for(Citation cit : citsList) {
				System.out.println("CITATION INFO > " + cit.asString(true));
			}

			// 7) Extract abstract sentences from a Dr. Inventor Document (ordered)
			List<Section> rootSectsList = doc_PDFpaperFILE.extractSections(true);
			for(Section rootSect : rootSectsList) {
				System.out.println("ROOT SECTION > " + rootSect.asString(true));
			}
			
			// 8.A) Get summary by ranking sentences by the centroid method
			List<Sentence> summarySentences_CENTROID = doc_PDFpaperFILE.extractSummary(20, SummaryTypeENUM.CENTROID_SECT);
			for(Sentence sent : summarySentences_CENTROID) {
				System.out.println(sent.getText());
			}

			// 8.B) Get summary by ranking sentences by the title
			List<Sentence> summarySentences_TITLE = doc_PDFpaperFILE.extractSummary(20, SummaryTypeENUM.TITILE_SIM);
			for(Sentence sent : summarySentences_TITLE) {
				System.out.println(sent.getText());
			}
			
			// 8) Extract abstract sentences from a Dr. Inventor Document (ordered)
						DependencyGraph docGraph = doc_PDFpaperFILE.extractDocumentGraph(SentenceSelectorENUM.ONLY_ABSTRACT);


		} catch (DRIexception e) {
			System.out.println("Error while extracting data from PDF file by means of the Dr. Inventor Text Mining Framework!");
			e.printStackTrace();
		}
	}

}
