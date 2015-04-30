package test;

import avis.SocialNetwork;
import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.NotItem;
import exception.NotMember;


/** 
 * @author N. Tanguy, J. Gutierrez
 * @date avril 2015
 * @version V2.0
 */


public class TestsReviewItemBook {

		// <=> Fiche de test n�1
		
		public static int  ReviewItemBookBadEntryTest(SocialNetwork sn, String pseudo,String idTest, String password, String titre,String commentaire, int note, String messErreur) {
			
			// v�rifie que l'ajout d'un item de livre est refus� (lev�e de l'exception BadEntry)	
			
			// ceci est incorrect, mais nous n'avons pas trouv� la solution pour la v�rification
			int nbAvis = sn.nbAvis();

			try {
				sn.reviewItemBook(pseudo, password, titre, note, commentaire);
				System.out.println ("Test " + idTest + " : " + messErreur);
				return 1;	
			} catch (BadEntry e) {
				if (sn.nbAvis() != nbAvis) {
					System.out.println("Test " + idTest + " : l'exception BadEntry a bien �t� lev�e mais le nombre d'avis sur un book a �t� modifi�");
					return 1;
				}
				else 
					return 0;
			}
			catch (Exception e) {
				System.out.println ("Test " + idTest + " : exception non pr�vue. " + e); 
				e.printStackTrace();
				return 1;
			}	
		}
		
		
		public static int ReviewItemBookNotItem(SocialNetwork sn,String idTest, String pseudo, String password, String titre, int note, String commentaire) {
			
			// on teste si le membre existe ou non

				try{
					sn.reviewItemBook(pseudo, password, titre, note, commentaire);
					System.out.println ("Test " + idTest + " : " + messErreur);
						return 1;
				} catch (NotItem e) {
					if (nbAvisAvt=!nbAvis) {
						System.out.println("Test " + idTest + " : l'exception NotItem a bien �t� lev�e mais le nombre d'avis a �t� modifi�");
						return 1;
				} 
					else 
					return 0;
				}
				catch (Exception e) {	
					System.out.println ("Test " + idTest + " : exception non pr�vue. " + e); 
					e.printStackTrace();
					return 1;
				}
			}
		
		public static int ReviewItemBookNotMember(SocialNetwork sn,String idTest, String pseudo, String password, String titre, int note, String commentaire) {
				// on teste si le membre existe ou non
				try{
					sn.reviewItemBook(pseudo, password, titre, note, commentaire);
					if (nbAvis()!=NbAvis()+1) {
						System.out.println("Test " + idTest + " :  le nombre d'avis n'a pas �t� correctement incr�ment�");
						return 1;
					}
					else 
						return 0;
				}
				catch (NotMember e) {
					if (nbAvisAvt=!nbAvis) {
						System.out.println("Test " + idTest + " : l'exception NotItem a bien �t� lev�e mais le nombre d'avis a �t� modifi�");
						return 1;
				}
					else  return 0;
					}
					
				catch (Exception e) {	
					System.out.println ("Test " + idTest + " : exception non pr�vue. " + e); 
					e.printStackTrace();
					return 1;
				}
			}
		
		
		public static int ReviewItemBookTestOK(SocialNetwork sn,String idTest, String pseudo, String password, String titre, int note, String commentaire) {
			
			//  incorrect mais pas de solution pour le moment
			float noteAvantAjout =sn.reviewItemBook(pseudo, password, titre, note, commentaire);
				// on teste si le membre existe ou non
						
		
				try{
					float noteApresAjout=sn.reviewItemBook(pseudo, password, titre, note, commentaire);
					
					if (noteAvantAjout != noteApresAjout) {
						System.out.println("Test " + idTest + " :  le nombre d'avis n'a pas �t� correctement incr�ment�");
						return 1;
					}
					else 
						return 0;
				}
				catch (Exception e) {	
					System.out.println ("Test " + idTest + " : exception non pr�vue. " + e); 
					e.printStackTrace();
					return 1;
				}
			}
		
		
	
	public static void main(String[] args) {
		
		int nbLivres = 0;
		int nbFilms = 0;
		// int nbAvis = 0; 

		int nbTests = 0;
		int nbErreurs = 0;
		
		System.out.println("Tests  ajouter des avis sur les books du r�seau social  ");

		SocialNetwork sn = new SocialNetwork();
		nbLivres = sn.nbBooks();
		// nbAvis = sn.nbAvis(); incorrect mais pas de solution trouv�e
		
		try {
		  	 sn.addMember("Nicolas","Nicolas","profil01");
	         sn.addMember("Julian","Julian","profil01");
	         sn.addMember("Jonat","Jonat","profil01");
		} catch (Exception e) {
			System.out.println("Impossible d'ajouter le membre");
		}
	   
		
		// <==> Fiche num�ro 5
		
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,null,"1.1", "cbncjehibc","Th�or�me du vivant","Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec un pseudo non instanci� fonctionne correctement");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"        ","1.2", "cbncjehibc","Th�or�me du vivant","Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec en param�tre un pseudo ne contenant que des espaces est accept�");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.3", "Nicolas",null,"Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec un titre non instanci� fonctionne correctement");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.4", "Nicolas","    ","Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec titre ne contenant que des blancs est accept�");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.5a", "Nicolas","Th�or�me du vivant","Mauvais livre...", 9, "L'ajout d'un avis sur un livre une note non comprise entre 0 et 5 est accept�");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.5b", "Nicolas","Th�or�me du vivant","Mauvais livre...", -3, "L'ajout d'un avis sur un livre une note non comprise entre 0 et 5 est accept�");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.6", "Nicolas","Th�or�me du vivant",null, 9, "L'ajout d'un avis sur un livre avec en param�tre un commentaire non instanci� est accept�");
		
		// <==> Fiche num�ro 6
		
		// Test ajout param�tre correct
		
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.1a","Nicolas", "Nicolas","Th�or�me du vivant",1, "Mauvais livre...");
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.1b","Julian", "Julian","Livre1",4, "Bon livre...");
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.1c","Jonat", "Jonat","Livre2",5, "Tr�s Bon livre...");
		

		// - Test pseudo non existant/couple login password incorrect
		
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.2/2.3","xxxxx", "cbncjehibc","Th�or�me du vivant",1, "Mauvais livre...");
		
		// Test titre livre non existant
		
		nbTests++;
		ReviewItemBookNotItem(sn,"2.4","Nicolas", "Nicolas","Titreincorrect", 5, "nul");
		//
		
		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);

		// bilan du test de ReviewItemBook
		System.out.println("TestsAddItemBook :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectu�s");
		
	}

}
