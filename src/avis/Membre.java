package avis;

import java.util.Collection;



/*
 * 
 * Ceci est un test de synchro github.
 * 
 * 
 */


public class Membre {
	
	private String pseudo;
	private String password;
	
	
	private Collection<Avis> avis = new java.util.ArrayList();

	/** 
	 * Getter of the property <tt>avis</tt>
	 * @return  Returns the avis.
	 * @uml.property  name="avis"
	 */
	public Collection<Avis> getAvis() {
		return avis;
	}

	/** 
	 * Setter of the property <tt>avis</tt>
	 * @param avis  The avis to set.
	 * @uml.property  name="avis"
	 */
	public void setAvis(Collection<Avis> avis) {
		this.avis = avis;
	}



	

	
	

	/** 
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="membre:avis.SocialNetwork"
	 */
	private SocialNetwork socialNetwork ;

	/** 
	 * Getter of the property <tt>socialNetwork</tt>
	 * @return  Returns the socialNetwork.
	 * @uml.property  name="socialNetwork"
	 */
	public SocialNetwork getSocialNetwork() {
		return socialNetwork;
	}

	/** 
	 * Setter of the property <tt>socialNetwork</tt>
	 * @param socialNetwork  The socialNetwork to set.
	 * @uml.property  name="socialNetwork"
	 */
	public void setSocialNetwork(SocialNetwork socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

		
		/**
		 */
		public void Membre(){
		}

		/**
		 * @uml.property  name="name"
		 */
		private String name;

		/**
		 * Getter of the property <tt>name</tt>
		 * @return  Returns the name.
		 * @uml.property  name="name"
		 */
		public String getName() {
			return name;
		}

		/**
		 * Setter of the property <tt>name</tt>
		 * @param name  The name to set.
		 * @uml.property  name="name"
		 */
		public void setName(String name) {
			this.name = name;
		}

}
