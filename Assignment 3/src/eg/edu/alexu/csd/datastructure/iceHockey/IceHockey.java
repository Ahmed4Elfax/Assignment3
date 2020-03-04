package eg.edu.alexu.csd.datastructure.iceHockey;
import java.awt.Point;
public class IceHockey implements IPlayerFinder {
    int max_x,max_y,min_x,min_y;
    int area=0;
    public Point[] arrayOfPoints=new Point[50];
    public int found (final int row,final int col,boolean arr[][],char a[][],char q) {
	  for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
			if ((row + i) >= 0 && (row + i) < a.length && (col + j) >= 0
				&& (col + j) < a[0].length && i != j && (i + j) != 0) {
			if ((a[row + i][col + j] == q )&& !arr[row + i][col + j]) {
					arr[row + i][col + j] = true;
						area++;
					if (max_x < (row + i)) {
						max_x = row + i;
					}
					if (min_x > (row + i)) {
						min_x = row + i;
					}
					if (max_y < (col + j)) {
						max_y= col + j;
					}
					if (min_y > (col + j)) {
						min_y = col + j;
					}
					found(row + i, col + j,arr,a,q);
					}
				}
			}
		}
	  return area;
  }
    Point [] sorting() {
    	int l=0;
		
		for(int n=0;n<arrayOfPoints.length;n++) {
			if(arrayOfPoints[n]!=null) {
				l++;}
		}
		Point [] sortedArray=new Point[l];
		for(int z=0;z<l;z++) {
		      sortedArray[z]=arrayOfPoints[z];
				}
		
		Point temp ;
		for(int a=0;a<l;a++) {
			for(int b=a;a<l;b++) {
			if (sortedArray[b].x<=sortedArray[a].x) {
				if(sortedArray[b].x==sortedArray[a].x) {
					if(sortedArray[b].y<sortedArray[a].y) {
						temp=sortedArray[a];
						sortedArray[a]=sortedArray[b];
						sortedArray[b]=temp;
					}
				}else {temp=sortedArray[a];
				sortedArray[a]=sortedArray[b];
				sortedArray[b]=temp;}
			}
		}}
		
	return sortedArray;
    }
  @Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
	 
		if (photo == null ) {
			return null;
		}
		else {
		char teamx = (char) (team + '0');
		char [][] photoPixels = new char[photo.length][photo[0].length()];
		boolean [][]player = new boolean [photo.length][photo[0].length()];
		for(int i=0 ;i<photo.length;i++) {
			for(int j =0;j<photo[0].length();j++) {
				photoPixels[i][j]=photo[i].charAt(j);
			}
		}
	
		for(int i=0 ;i<photo.length;i++) {
			for(int j =0;j<photo[0].length();j++) {
				player[i][j]=false;
			}
		}
		
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				if(photoPixels[i][j]==teamx  &&  !player[i][j]) {
				area++;
				player[i][j]=true;
				max_x=i;
				max_y=j;
				min_x=i;
				min_y=j;
				area=found(i, j, player, photoPixels, teamx);
				if (area >= (float)threshold/4) {
					int mid_x,mid_y;
					mid_x=max_x+min_x+1;
					mid_y=max_y+min_y+1;
				Point ok = new Point (mid_y,mid_x);	
				int m =0;
				for (m=0;m<50;m++) {
					if (arrayOfPoints[m]==null) {break;}
				}
				arrayOfPoints[m]=ok;
				}
				area=0;
				}
			}}
        int l=0;
		for(int n=0;n<arrayOfPoints.length;n++) {
			if(arrayOfPoints[n]!=null) {
				l++;}
		    Point temp ;
			try{for(int a=0;a<l;a++) {
				for(int b=a+1;b<l;b++) {
				    if((arrayOfPoints[b].x == arrayOfPoints[a].x)&&(arrayOfPoints[b].y < arrayOfPoints[a].y)) {
			            	temp=arrayOfPoints[a];
							arrayOfPoints[a]=arrayOfPoints[b];
							arrayOfPoints[b]=temp;
						
					}else if (arrayOfPoints[b].x < arrayOfPoints[a].x)
					{temp=arrayOfPoints[a];
					arrayOfPoints[a]=arrayOfPoints[b];
					arrayOfPoints[b]=temp;}
				}
			}}
			catch (Exception e) {
			System.out.println("Null Array");	
			}
			/*int l=0;
		
		for(int n=0;n<arrayOfPoints.length;n++) {
			if(arrayOfPoints[n]!=null) {
				l++;}*/
		}
	Point [] sortedArray=new Point[l];
	for(int z=0;z<l;z++) {
	      sortedArray[z]=arrayOfPoints[z];
			}
		return sortedArray;

}}}
