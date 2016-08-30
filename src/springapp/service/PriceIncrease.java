package springapp.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotBlank;

public class PriceIncrease {
	protected final Log logger = LogFactory.getLog(getClass());

	@NotNull(message="No inputs!!  If wanted to increase price, please provide a input.")
	@Min(value=1, message="You have to specify a percentage higher than 0")
	@Max(value=50, message="Don't be too greedy - you can't raise prices by more than 50%")
	private int percentage;

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
		logger.info("Percentage set to " + percentage);
	}
}
