package avis;

import java.util.Collection;


public class Item {

	/**
	 * @uml.property  name="avis"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="item:avis.Avis"
	 */
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
	 * @uml.property  name="socialNetwork"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="item:avis.SocialNetwork"
	 */
	private Collection<SocialNetwork> socialNetwork;

	/**
	 * Getter of the property <tt>socialNetwork</tt>
	 * @return  Returns the socialNetwork.
	 * @uml.property  name="socialNetwork"
	 */
	public Collection<SocialNetwork> getSocialNetwork() {
		return socialNetwork;
	}

	/**
	 * Setter of the property <tt>socialNetwork</tt>
	 * @param socialNetwork  The socialNetwork to set.
	 * @uml.property  name="socialNetwork"
	 */
	public void setSocialNetwork(Collection<SocialNetwork> socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

}
