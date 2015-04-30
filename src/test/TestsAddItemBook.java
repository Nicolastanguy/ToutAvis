package test;

import java.util.LinkedList;

import avis.SocialNetwork;
import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;

/** 
 * @author N. Tanguy, J. Gutierrez
 * @date avril 2015
 * @version V1.0
 */

public class TestsAddItemBook {

	// <=> Fiche de test n°1
	
	public static int  AddItemBookBadEntryTest(SocialNetwork sn, String pseudo,String idTest, String password, String titre, String genre, String auteur, int nbPages, String messErreur) {
		
		// vérifie que l'ajout d'un item de livre est refusé (levée de l'exception BadEntry)
	
		int nbBooks = sn.nbBooks();
		
		try {
			sn.addItemBook(pseudo, password, titre, genre, auteur, nbPages);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;	
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Test " + idTest + " : l'exception BadEntry a bien été levée mais le nombre de book a été modifié");
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
	
	
	// <=> fiche de test n°2 
	public static int addItemBookTestOK(SocialNetwork sn,String idTest,String pseudo,String password,String titre, String genre, String auteur, int nbPages) {
		
		int nbBooks = sn.nbBooks();
	
				
		try{
		
			sn.addItemBook(pseudo, password, titre, genre, auteur, nbPages) ;
			if (sn.nbBooks() != sn.nbBooks()+1) {
				System.out.println("Test " + idTest + " :  le nombre de book n'a pas été correctement incrémenté");
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
	
	public static int addAlreadyExistsTest (SocialNetwork sn,String idTest,String pseudo,String password,String titre, String genre, String auteur, int nbPages, String messErreur){
		int nbBooks = sn.nbBooks();
		try {
			sn.addItemBook(pseudo, password, titre, genre, auteur, nbPages);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (ItemBookAlreadyExists e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Test " + idTest + " : l'exception ItemBookAlreadyExists a bien été levée mais le nombre de book a été modifié");
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
	
	
	public static int addNotMemberTest (SocialNetwork sn,String idTest,String pseudo,String password,String titre, String genre, String auteur, int nbPages, String messErreur) {
		
		int nbBooks = sn.nbBooks();
		
		try {
			sn.addItemBook(pseudo, password, titre, genre, auteur, nbPages);
			System.out.println ("Test " + idTest + " : " + messErreur);
			return 1;
		}
		catch (NotMember e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Test " + idTest + " : l'exception NotMember a bien été levée mais le nombre de book a été modifié");
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
	
	
	
	public static void main(String[] args){	

		int nbLivres = 0;
		int nbFilms = 0;

		int nbTests = 0;
		int nbErreurs = 0;
		
		System.out.println("Tests  ajouter des books au réseau social  ");


		SocialNetwork sn = new SocialNetwork();
		nbLivres = sn.nbBooks();
        
        //création de membres
        
        try {
			sn.addMember("Paul","Paul","profil01");
			sn.addMember("Antoine","antoine","profil01");
		} catch (Exception e) {
		System.out.println("Impossible d'ajouter le membre");
		}
         
		
		// <=> fiche numéro 3
		
		nbTests++;
		nbErreurs += AddItemBookBadEntryTest ( sn, null, "1.1", "","Le théorème de Vivant","Mathématiques","Cédric Villani",288, "L'ajout d'un item de book dont le pseudo n'est pas instancié est accepté");
		nbTests++;
		nbErreurs += AddItemBookBadEntryTest ( sn, "   ", "1.2", "","Le théorème de Vivant","Mathématiques","Cédric Villani",288, "L'ajout d'un book dont le pseudo du membre ne contient pas un caracteres, autre que des espaces, est accepté");
		nbTests++;
		nbErreurs+=AddItemBookBadEntryTest ( sn, "Nicolas", "1.3", "",null,"Mathématiques","Cédric Villani",288, "L'ajout d'un membre dont le titre n'est pas instancié est accepté");
		nbTests++;
		nbErreurs+=AddItemBookBadEntryTest ( sn, "Nicolas", "1.4", "","    ","Mathématiques","Cédric Villani",288, "L'ajout d'un book dont le titre ne contient pas un caractère, autre que des espaces est accepté");
		nbTests++;
		nbErreurs+=AddItemBookBadEntryTest ( sn, "Nicolas", "1.5", "","Le théorème de Vivant",null,"Cédric Villani",288, "L'ajout d'un book dont le genre n'est pas instancié est accepté");
		nbTests++;
		nbErreurs+=AddItemBookBadEntryTest ( sn, "Nicolas", "1.6", "","Le théorème de Vivant","Mathématiques",null,288, "L'ajout d'un book dont l'auteur n'est pas instancié est accepté");
		nbTests++;
		nbErreurs+=AddItemBookBadEntryTest ( sn, "Nicolas", "1.7", "","Le théorème de Vivant","Mathématiques","Cédric Villani",-156, "L'ajout d'un book dont le nombre de page est négatif est accepté");
		
		

		// <=> fiche numéro 4

				// ajout de 3 book avec entrées "correctes"

				nbTests++;
				nbErreurs += addItemBookTestOK (sn, "2.1a","Paul", "paul", "Le théorème de Vivant","Mathématiques","Cédric Villani",288);
				nbTests++;
				nbErreurs += addItemBookTestOK (sn, "2.1b","Antoine", "antoine", "grand amoureux de la littérature","Littérature classique","Victor Hugo",288);
        

				//ajout livre paramètre pseudo non existant
				
				nbTests++;
				nbErreurs +=addNotMemberTest (sn, "2.3ab","behjifbie", "nicolas", "nfejonerjof","Littérature classique","Victor Hugo",324,"L'ajout d'un livre avec un membre non existant est accepté");
				
				//ajout livre pseudo || couple login password incorrect
				
				nbTests++;
				nbErreurs +=addNotMemberTest (sn, "2.3ab","behjifbie", "bfjkebfj", "nfejonerjof","Littérature classique","Victor Hugo",324,"L'ajout d'un livre avec un membre non existant est accepté");
				
				
				//Ajout d'un livre avec un item déjà existant
			
				nbTests++;
				addAlreadyExistsTest (sn,"2.4","Paul", "paul", "Le théorème de Vivant","Mathématiques","Cédric Villani",288,"L'ajout d'un livre avec le même nom que le premier livre ajouté est accepté");
				nbErreurs++;
				addAlreadyExistsTest (sn,"2.4","Antoine", "paul", "grand amoureux de la littérature","Littérature classique","Cédric Villani",288,"L'ajout d'un livre avec le même nom que le dernier livre ajouté est accepté");
				nbErreurs++;
				addAlreadyExistsTest (sn,"2.4","Antoine", "paul", "Grand amOureux DE la LIttérature","Littérature classique","Cédric Villani",288,"L'ajout d'un livre avec le même nom que le dernier livre ajouté avec casse différente est accepté");
				
			
				// ce n'est pas du test, mais cela peut "rassurer"...
				System.out.println(sn);

				// bilan du test de addMember
				System.out.println("TestsAddItemBook :   " + nbErreurs + " erreur(s) / " +  nbTests + " tests effectués");
		
	}

}
