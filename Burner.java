enum Temperature {
	
	BLAZING("VERY HOT! DON'T TOUCH!"), HOT("CAREFUL"), WARM("warm"), COLD("cooool");
	private String value;
	
	Temperature(String aValue) {
		value = aValue;
	}
	
	public String toString() {
		return value;
	}
}

public class Burner{
	
	public final static int TIME_DURATION = 2;
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		
	}
	
	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	// this method increase the setting of the burner
	public void plusButton() {
		switch (mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			default:
		}
		timer = TIME_DURATION;
	}

	// this method decrease the setting of button
	public void minusButton() {
		switch (mySetting) {
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.OFF;
				break;
			default:
		}
		timer = TIME_DURATION;
	}

	public void updateTemperature() {
		timer--;
		// when is setting LOW, and timer is 0, decrease the temperature to warm
		if (mySetting == Setting.LOW) {
			if (timer == 0) {
				switch (myTemperature) {
					case BLAZING:
						myTemperature = Temperature.HOT;
						timer = TIME_DURATION;
						break;
					case HOT:
						myTemperature = Temperature.WARM;
						timer = TIME_DURATION;
						break;
					case COLD:
						myTemperature = Temperature.WARM;
						timer = TIME_DURATION;
						break;
					default:
				}
			}
		}
		// when setting is MEDIUM, and timer is 0, increase the temperature from cold to warm, warm to hot, decrease from blazing to hot
		else if (mySetting == Setting.MEDIUM) {
			if (timer == 0) {
				switch (myTemperature) {
					case COLD:
						myTemperature = Temperature.WARM;
						timer = TIME_DURATION;
						break;
					case WARM:
						myTemperature = Temperature.HOT;
						timer = TIME_DURATION;
						break;
					case BLAZING:
						myTemperature = Temperature.HOT;
					default:
				}
			}
		}
		// when setting is HIGH, and timer is 0, increase cold to warm, warm to hot, and hot to blazing
		else if (mySetting == Setting.HIGH) {
			if (timer == 0) {
				switch (myTemperature) {
					case COLD:
						myTemperature = Temperature.WARM;
						timer = TIME_DURATION;
						break;
					case WARM:
						myTemperature = Temperature.HOT;
						timer = TIME_DURATION;
						break;
					case HOT:
						myTemperature = Temperature.BLAZING;
						timer = TIME_DURATION;
						break;
					default:
				}
			}
		}
		// when setting is off, and timer is 0, decrease blazing to hot, warm to cold, and hot to warm
		else {
			if (timer == 0) {
				switch (myTemperature) {
					case BLAZING:
						myTemperature = Temperature.HOT;
						timer = TIME_DURATION;
						break;
					case WARM:
						myTemperature = Temperature.COLD;
						timer = TIME_DURATION;
						break;
					case HOT:
						myTemperature = Temperature.WARM;
						timer = TIME_DURATION;
						break;
					default:
				}
			}
		}
		
		
	}
	public void display() {
		String message = "[" + mySetting.toString() + "]......" + myTemperature; 
		System.out.println(message);
	}
	
	
}