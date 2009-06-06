package de.toolforge.googlechartwrapper;

import java.awt.Dimension;
import java.util.Collections;
import java.util.List;

import de.toolforge.googlechartwrapper.WorldMap.Country;
import de.toolforge.googlechartwrapper.WorldMap.CountryCode;
import de.toolforge.googlechartwrapper.WorldMap.CountryName;
import de.toolforge.googlechartwrapper.WorldMap.GeographicalArea;
import de.toolforge.googlechartwrapper.color.ChartColor;

/**
 * Specifies a map <a href="http://code.google.com/apis/chart/types.html#maps">
 * http://code.google.com/apis/chart/types.html#maps</a>.
 * 
 * <p>
 * Here are some examples of how usaMap can be used:
 * <p><blockquote><pre>  
 *     UsaMap newEnglandStates = new UsaMap(new Dimension(400,200),Arrays.asList(new UsaMap.State(UsaMap.StateCode.CT,100),new UsaMap.State(UsaMap.StateCode.ME,100))
 * </pre></blockquote>
 * <p>
 *
 * @author martin
 * @author steffan
 * @version 06/06/09 
 * @see Country
 * @see CountryCode
 * @see CountryName
 * @see GeographicalArea
 * @see AbstractMap
 * @see WorldMap
 */
public class UsaMap extends AbstractMap{
	
	private List<State> stateList;
	private GeographicalArea area;
	
	/**
	 * Constructs a new map, with usa as {@link Country}, the list contains all states.
	 * 
	 * @param chartDimension
	 * @param stateList
	 *            list of states {@link State}, can be empty to show only the
	 *            us.
	 * 
	 * @throws IllegalArgumentException
	 *             if stateList is {@code null} or member is {@code null}
	 * @throws IllegalArgumentException
	 *             if chartDimension is out of range
	 */
	public UsaMap(Dimension chartDimension, List<State> stateList) {
		super(chartDimension);

		if (stateList == null)
			throw new IllegalArgumentException("stateList can not be null");

		List<State> copy = Collections.unmodifiableList(stateList);
		for (State current : copy) {
			if (current == null)
				throw new IllegalArgumentException("listMember can not be null");
		}
		if (chartDimension.height > 220) {
			throw new IllegalArgumentException("height must be <= 220");
		}
		if (chartDimension.width > 440) {
			throw new IllegalArgumentException("width must be <= 440");
		}

		this.stateList = copy;
		this.area = GeographicalArea.USA;
	}
	
	/**
	 * Sets the {@link State}.
	 * 
	 * @param stateList
	 * 
	 * @throws IllegalArgumentException
	 *             if stateList is {@code null} or member is {@code null}
	 */
	public void setStateList(List<State> stateList){
		if (stateList == null)
			throw new IllegalArgumentException("stateList can not be null");

		List<State> copy = Collections.unmodifiableList(stateList);
		for (State current : copy) {
			if (current == null)
				throw new IllegalArgumentException("listMember can not be null");
		}
		
		this.stateList = copy;
	}
	
	/**
	 * Returns a unmodifiable view of the list.
	 * 
	 * @return list or {@code null}
	 */
	public List<State> getStateList(){
		
		return Collections.unmodifiableList(this.stateList);
	}
	
	@Override
	protected void collectUrlElements() {
		super.collectUrlElements();

		urlElements.offer("chtm=" + area.getAreaCode()); // area code

		// the usa case
		if (this.stateList != null) {
			StringBuilder states = new StringBuilder();
			StringBuilder colorLevel = new StringBuilder();

			// see what's in the list
			for (State current : stateList) {
				states.append(current.getCode());
				colorLevel.append(current.getColorLevel());
				colorLevel.append(",");
			}
			// cut the last ','
			if (colorLevel.length() > 1) {
				colorLevel.deleteCharAt(colorLevel.length() - 1);
			}

			urlElements.offer("chld=" + states.toString());
			urlElements.offer("chd=t:" + colorLevel);
		}		
	}
	
	/**
	 * USA state name code.
	 * 
	 */
	public enum StateCode {
		/** Alabama. **/
		AL,
		/** Alaska. **/
		AK,
		/** Arizona. **/
		AZ,
		/** Arkansas. **/
		AR,
		/** California. **/
		CA,
		/** Colorado. **/
		CO,
		/** Connecticut. **/
		CT,
		/** Delaware. **/
		DE,
		/** Florida. **/
		FL,
		/** Georgia. **/
		GA,
		/** Hawaii. **/
		HI,
		/** Idaho. **/
		ID,
		/** Illinois. **/
		IL,
		/** Indiana. **/
		IN,
		/** Iowa. **/
		IA,
		/** Kansas. **/
		KS,
		/** Kentucky. **/
		KY,
		/** Louisiana. **/
		LA,
		/** Maine. **/
		ME,
		/** Maryland. **/
		MD,
		/** Massachusetts. **/
		MA,
		/** Michigan. **/
		MI,
		/** Minnesota. **/
		MN,
		/** Mississippi. **/
		MS,
		/** Missouri. **/
		MO,
		/** Montana. **/
		MT,
		/** Nebraska. **/
		NE,
		/** Nevada. **/
		NV,
		/** New_hampshire. **/
		NH,
		/** New_jersey. **/
		NJ,
		/** New_mexico. **/
		NM,
		/** New_york. **/
		NY,
		/** North_carolina. **/
		NC,
		/** North_dakota. **/
		ND,
		/** Ohio. **/
		OH,
		/** Oklahoma. **/
		OK,
		/** Oregon. **/
		OR,
		/** Pennsylvania. **/
		PA,
		/** Rhode_island. **/
		RI,
		/** South_carolina. **/
		SC,
		/** South_dakota. **/
		SD,
		/** Tennessee. **/
		TN,
		/** Texas. **/
		TX,
		/** Utah. **/
		UT,
		/** Vermont. **/
		VT,
		/** Virginia. **/
		VA,
		/** Washington. **/
		WA,
		/** West_virginia. **/
		WV,
		/** Wisconsin. **/
		WI,
		/** Wyoming. **/
		WY;
	}
	
	/**
	 * Provides an object for the {@link AbstractMap#Map(Dimension, List)} contructor.
	 * 
	 * @author steffan
	 * 
	 * 
	 */
	public static class State {

		private int colorLevel;
		private String code;
		
		/**
		 * USA State name.
		 */
		public enum StateName {
			/** Alabama. **/
			ALABAMA("AL"),
			/** Alaska. **/
			ALASKA("AK"),
			/** Arizona. **/
			ARIZONA("AZ"),
			/** Arkansas. **/
			ARKANSAS("AR"),
			/** California. **/
			CALIFORNIA("CA"),
			/** Colorado. **/
			COLORADO("CO"),
			/** Connecticut. **/
			CONNECTICUT("CT"),
			/** Delaware. **/
			DELAWARE("DE"),
			/** Florida. **/
			FLORIDA("FL"),
			/** Georgia. **/
			GEORGIA("GA"),
			/** Hawaii. **/
			HAWAII("HI"),
			/** Idaho. **/
			IDAHO("ID"),
			/** Illinois. **/
			ILLINOIS("IL"),
			/** Indiana. **/
			INDIANA("IN"),
			/** Iowa. **/
			IOWA("IA"),
			/** Kansas. **/
			KANSAS("KS"),
			/** Kentucky. **/
			KENTUCKY("KY"),
			/** Louisiana. **/
			LOUISIANA("LA"),
			/** Maine. **/
			MAINE("ME"),
			/** Maryland. **/
			MARYLAND("MD"),
			/** Massachusetts. **/
			MASSACHUSETTS("MA"),
			/** Michigan. **/
			MICHIGAN("MI"),
			/** Minnesota. **/
			MINNESOTA("MN"),
			/** Mississippi. **/
			MISSISSIPPI("MS"),
			/** Missouri. **/
			MISSOURI("MO"),
			/** Montana. **/
			MONTANA("MT"),
			/** Nebraska. **/
			NEBRASKA("NE"),
			/** Nevada. **/
			NEVADA("NV"),
			/** New_hampshire. **/
			NEW_HAMPSHIRE("NH"),
			/** New_jersey. **/
			NEW_JERSEY("NJ"),
			/** New_mexico. **/
			NEW_MEXICO("NM"),
			/** New_york. **/
			NEW_YORK("NY"),
			/** North_carolina. **/
			NORTH_CAROLINA("NC"),
			/** North_dakota. **/
			NORTH_DAKOTA("ND"),
			/** Ohio. **/
			OHIO("OH"),
			/** Oklahoma. **/
			OKLAHOMA("OK"),
			/** Oregon. **/
			OREGON("OR"),
			/** Pennsylvania. **/
			PENNSYLVANIA("PA"),
			/** Rhode_island. **/
			RHODE_ISLAND("RI"),
			/** South_carolina. **/
			SOUTH_CAROLINA("SC"),
			/** South_dakota. **/
			SOUTH_DAKOTA("SD"),
			/** Tennessee. **/
			TENNESSEE("TN"),
			/** Texas. **/
			TEXAS("TX"),
			/** Utah. **/
			UTAH("UT"),
			/** Vermont. **/
			VERMONT("VT"),
			/** Virginia. **/
			VIRGINIA("VA"),
			/** Washington. **/
			WASHINGTON("WA"),
			/** West_virginia. **/
			WEST_VIRGINIA("WV"),
			/** Wisconsin. **/
			WISCONSIN("WI"),
			/** Wyoming. **/
			WYOMING("WY");

			/** String for the Google Chart API parameter. */
			private final String name;

			/**
			 * Instantiating enum.
			 * 
			 * @param name
			 *            the string for the Google Chart API parameter
			 */
			private StateName(final String name) {
				this.name = name;
			}

			/**
			 * Returns the state code, e.g. WY for Wyoming.
			 * 
			 * @return the country code
			 */
			public String getStateCode() {
				return this.name;
			}
		
	}
		
		


		/**
		 * Constructs a new state for the {@link AbstractMap}.
		 * 
		 * @param name
		 *            {@link StateName} the to show
		 * @param colorLevel
		 *            a value between 0 and 100, the integer you provide here
		 *            will be interpolated with the color gradient that you
		 *            defined in {@link AbstractMap#addChartColor(ChartColor)}
		 * 
		 * @throws IllegalArgumentException
		 *             if name is {@code null}
		 * @throws IllegalArgumentException
		 *             colorLevel can not be < 0 or > 100
		 */
		public State(StateName name, int colorLevel) {

			if (name == null)
				throw new IllegalArgumentException("name can not be null");
			if (colorLevel < 0 || colorLevel > 100)
				throw new IllegalArgumentException(
						"colorLevel can not be < 0 oder > 100");

			this.colorLevel = colorLevel;
			this.code = name.getStateCode();

		}

		/**
		 * Constructs new state fpr the {@link AbstractMap}.
		 * 
		 * @param name
		 *            {@link StateName} the to show
		 * @param colorLevel
		 *            a value between 0 and 100, the integer you provide here
		 *            will be interpolated with the color gradient that you
		 *            defined in {@link AbstractMap#addChartColor(ChartColor)}
		 * 
		 * @throws IllegalArgumentException
		 *             if code is {@code null}
		 * @throws IllegalArgumentException
		 *             colorLevel can not be < 0 or > 100
		 */
		public State(StateCode code, int colorLevel) {

			if (code == null)
				throw new IllegalArgumentException("code can not be null");
			if (colorLevel < 0 || colorLevel > 100)
				throw new IllegalArgumentException(
						"colorLevel can not be < 0 oder > 100");

			this.colorLevel = colorLevel;
			this.code = code.toString();
		}

		/**
		 * The construtor accepts a string for the state code, better use the
		 * enum, it its safer.
		 * 
		 * @param code
		 *            e.g. CA for california
		 * @param colorLevel
		 *            colorLevel a value between 0 and 100, the integer you
		 *            provide here will be interpolated with the color gradient
		 *            that you defined in {@link AbstractMap#addChartColor(ChartColor)}
		 * 
		 * @throws IllegalArgumentException
		 *             if code is {@code null}
		 * @throws IllegalArgumentException
		 *             colorLevel can not be < 0 or > 100
		 */
		public State(String code, int colorLevel) {

			if (code == null)
				throw new IllegalArgumentException("code can not be null");
			if (colorLevel < 0 || colorLevel > 100)
				throw new IllegalArgumentException(
						"colorLevel can not be < 0 oder > 100");

			this.colorLevel = colorLevel;
			this.code = code;

		}
		/**
		 * Returns the color level, a value between 0 and 100 to interpolate the color.
		 * 
		 * @return the colorLevel
		 */
		public int getColorLevel() {
			return colorLevel;
		}

		/**
		 * Sets the color level, a value between 0 and 100 to interpolate the color.
		 * 
		 * @param colorLevel
		 *            the colorLevel to set
		 * 
		 * @throws IllegalArgumentException
		 *             colorLevel can not be < 0 or > 100
		 */
		public void setColorLevel(int colorLevel) {

			if (colorLevel < 0 || colorLevel > 100)
				throw new IllegalArgumentException(
						"colorLevel can not be < 0 oder > 100");

			this.colorLevel = colorLevel;
		}

		/**
		 * @return the code the state code convertet to string
		 */
		public String getCode() {
			return code;
		}
}
}
