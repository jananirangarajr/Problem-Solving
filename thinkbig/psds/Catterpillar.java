package thinkbig.psds;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jaanu
 *{@link https://practice.geeksforgeeks.org/problems/jumping-caterpillars/0}
 */
class CatterpillarDetails{
	int leaves;
	public int getLeaves() {
		return leaves;
	}
	
	ArrayList<Integer> caterpillarOrder;
	
	public void setCaterpillarOrder(int order) {
		caterpillarOrder.add(order);
	}

	public ArrayList<Integer> getcaterpillarOrder() {
		return caterpillarOrder;
	}
	
	int noOfCatterpillar;
	public int getNoOfCatterpillar() {
		return noOfCatterpillar;
	}
	
	int result;
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	CatterpillarDetails(int leaves, int noOfCaterpillar)
	{
		this.leaves = leaves;
		this.noOfCatterpillar = noOfCaterpillar;
		this.caterpillarOrder = new ArrayList<Integer>(noOfCaterpillar);
	}
}

public class Catterpillar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		CatterpillarDetails[] detailsObj = new CatterpillarDetails[testcase];
		for(int i = 0 ; i < testcase ; i++)
		{
			int leaves = sc.nextInt();
			int noOfCatterpillar = sc.nextInt();
			detailsObj[i] = new CatterpillarDetails(leaves,noOfCatterpillar);
			
			boolean[] eaten = new boolean[leaves];
			for(int j = 0 ; j < noOfCatterpillar ; j++) {
				int catterpillarOrder = sc.nextInt();
				detailsObj[i].setCaterpillarOrder(catterpillarOrder);
				
				for(int k = 1 ; k <= leaves ; k++)
				{
					if(catterpillarOrder*k > leaves)
						break;
					else
					{
						eaten[(catterpillarOrder*k)-1] = true;
					}
				}
			}
			detailsObj[i].setResult(calculateNotEaten(eaten));
		}
		for(int i = 0 ; i < testcase ; i++)
		{
			System.out.println(detailsObj[i].getResult());
		}
	}

	private static int calculateNotEaten(boolean[] eaten) {
		// TODO Auto-generated method stub
		int count = 0;
		for(Boolean i : eaten)
		{
			if(!i)
			{
				count++;
			}
		}
		return count;
	}
}
