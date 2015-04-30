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

		// <=> Fiche de test n°1
		
		public static int  ReviewItemBookBadEntryTest(SocialNetwork sn, String pseudo,String idTest, String password, String titre,String commentaire, int note, String messErreur) {
			
			// vérifie que l'ajout d'un item de livre est refusé (levée de l'exception BadEntry)	
			
			// ceci est incorrect, mais nous n'avons pas trouvé la solution pour la vérification
			int nbAvis = sn.nbAvis();

			try {
				sn.reviewItemBook(pseudo, password, titre, note, commentaire);
				System.out.println ("Test " + idTest + " : " + messErreur);
				return 1;	
			} catch (BadEntry e) {
				if (sn.nbAvis() != nbAvis) {
					System.out.println("Test " + idTest + " : l'exception BadEntry a bien été levée mais le nombre d'avis sur un book a été modifié");
					return 1;
				}
				else 
					return 0;
			}
			catch (Exception e) {
				System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
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
						System.out.println("Test " + idTest + " : l'exception NotItem a bien été levée mais le nombre d'avis a été modifié");
						return 1;
				} 
					else 
					return 0;
				}
				catch (Exception e) {	
					System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
					e.printStackTrace();
					return 1;
				}
			}
		
		public static int ReviewItemBookNotMember(SocialNetwork sn,String idTest, String pseudo, String password, String titre, int note, String commentaire) {
				// on teste si le membre existe ou non
				try{
					sn.reviewItemBook(pseudo, password, titre, note, commentaire);
					if (nbAvis()!=NbAvis()+1) {
						System.out.println("Test " + idTest + " :  le nombre d'avis n'a pas été correctement incrémenté");
						return 1;
					}
					else 
						return 0;
				}
				catch (NotMember e) {
					if (nbAvisAvt=!nbAvis) {
						System.out.println("Test " + idTest + " : l'exception NotItem a bien été levée mais le nombre d'avis a été modifié");
						return 1;
				}
					else  return 0;
					}
					
				catch (Exception e) {	
					System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
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
						System.out.println("Test " + idTest + " :  le nombre d'avis n'a pas été correctement incrémenté");
						return 1;
					}
					else 
						return 0;
				}
				catch (Exception e) {	
					System.out.println ("Test " + idTest + " : exception non prévue. " + e); 
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
		
		System.out.println("Tests  ajouter des avis sur les books du réseau social  ");

		SocialNetwork sn = new SocialNetwork();
		nbLivres = sn.nbBooks();
		// nbAvis = sn.nbAvis(); incorrect mais pas de solution trouvée
		
		try {
		  	 sn.addMember("Nicolas","Nicolas","profil01");
	         sn.addMember("Julian","Julian","profil01");
	         sn.addMember("Jonat","Jonat","profil01");
		} catch (Exception e) {
			System.out.println("Impossible d'ajouter le membre");
		}
	   
		
		// <==> Fiche numéro 5
		
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,null,"1.1", "cbncjehibc","Théorème du vivant","Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec un pseudo non instancié fonctionne correctement");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"        ","1.2", "cbncjehibc","Théorème du vivant","Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec en paramètre un pseudo ne contenant que des espaces est accepté");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.3", "Nicolas",null,"Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec un titre non instancié fonctionne correctement");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.4", "Nicolas","    ","Mauvais livre...", 5, "L'ajout d'un avis sur un livre avec titre ne contenant que des blancs est accepté");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.5a", "Nicolas","Théorème du vivant","Mauvais livre...", 9, "L'ajout d'un avis sur un livre une note non comprise entre 0 et 5 est accepté");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.5b", "Nicolas","Théorème du vivant","Mauvais livre...", -3, "L'ajout d'un avis sur un livre une note non comprise entre 0 et 5 est accepté");
		nbTests++;
		nbErreurs += ReviewItemBookBadEntryTest(sn,"Nicolas","1.6", "Nicolas","Théorème du vivant",null, 9, "L'ajout d'un avis sur un livre avec en paramètre un commentaire non instancié est accepté");
		
		// <==> Fiche numéro 6
		
		// Test ajout paramètre correct
		
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.1a","Nicolas", "Nicolas","Théorème du vivant",1, "Mauvais livre...");
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.1b","Julian", "Julian","Livre1",4, "Bon livre...");
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.1c","Jonat", "Jonat","Livre2",5, "Très Bon livre...");
		

		// - Test pseudo non existant/couple login password incorrect
		
		nbTests++;
		nbErreurs += ReviewItemBookTestOK(sn,"2.2/2.3","xxxxx", "cbncjehibc","Théorème du vivant",1, "Mauvais livre...");
		
		// Test titre livre non existant
		
		nbTests++;
		ReviewItemBookNotItem(sn,"2.4","Nicolas", "Nicolas","Titreincorrect", 5, "nul");
		//
		
		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);

		// bilan du test de ReviewItemBook
		System.out.println("TestsAddItemBook :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectués");
		
	}

}
