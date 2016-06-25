import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MaxPriceReduce extends Reducer<DoubleWritable,NullWritable,Text,DoubleWritable>{
	Text Title = new Text();
	double MaxPrice = 0;
	public void reduce(DoubleWritable key,Iterable<NullWritable> values,Context context){
		double price = Double.parseDouble(key.toString());
		if(price > MaxPrice){
			MaxPrice = price ;	
		}
		Title.set("Max(Price)");
		}
	public void cleanup(Context context){
	try {
		context.write(Title,new DoubleWritable(MaxPrice));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
}
