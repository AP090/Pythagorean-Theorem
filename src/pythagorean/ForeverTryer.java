package pythagorean;

public class ForeverTryer {
	public static void untilPass(TryForeverCallback cb) {
		while (true) {
			try {
				cb.run();
				break;
			} catch (Exception err) { }
		}
	}
	
	public static void untilPass(TryForeverCallback cb, TryForeverErrorCallback errcb) {
		while (true) {
			try {
				cb.run();
				break;
			} catch (Exception err) {
				errcb.run();
			}
		}
	}
}
