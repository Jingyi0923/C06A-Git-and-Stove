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