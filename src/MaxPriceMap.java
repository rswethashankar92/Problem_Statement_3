import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MaxPriceMap extends Mapper<LongWritable,Text,DoubleWritable,NullWritable> {

	public void map(LongWritable key,Text value,Context context){
		if (Long.parseLong(key.toString()) == 0)
			return;
		else{
		String[] val = value.toString().split(",");
		String Price = val[3];
		try {
			context.write(new DoubleWritable(Double.parseDouble(Price)),NullWritable.get());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
