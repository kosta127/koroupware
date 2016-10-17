


public class random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String randomChar = null;
		String Array[];
		Array = new String[8];
		
		for(int i=0; i<8; i++){
			int randomValue = (int)(Math.random()*35)+0;
			System.out.println("랜덤 수: "+randomValue);
			for(int j=0; j<8; j++){
				if(randomValue==0){
					randomChar="0";
					
				}else if(randomValue==1){
					randomChar="1";
					Array[i] = randomChar;
				}else if(randomValue==2){			
					randomChar="2";
					Array[i] = randomChar;
				}else if(randomValue==3){
					randomChar="3";
					Array[i] = randomChar;
				}else if(randomValue==4){
					randomChar="4";
					Array[i] = randomChar;
				}else if(randomValue==5){
					randomChar="5";
					Array[i] = randomChar;
				}else if(randomValue==6){
					randomChar="6";
					Array[i] = randomChar;
				}else if(randomValue==7){
					randomChar="7";
					Array[i] = randomChar;
				}else if(randomValue==8){
					randomChar="8";
					Array[i] = randomChar;
				}else if(randomValue==9){
					randomChar="9";
					Array[i] = randomChar;
				}else if(randomValue==10){
					randomChar="A";
					Array[i] = randomChar;
				}else if(randomValue==11){
					randomChar="B";
					Array[i] = randomChar;
				}else if(randomValue==12){
					randomChar="C";
					Array[i] = randomChar;
				}else if(randomValue==13){
					randomChar="E";
					Array[i] = randomChar;
				}else if(randomValue==14){
					randomChar="F";
					Array[i] = randomChar;
				}else if(randomValue==15){
					randomChar="G";
					Array[i] = randomChar;
				}else if(randomValue==16){
					randomChar="H";
					Array[i] = randomChar;
				}else if(randomValue==17){
					randomChar="I";
					Array[i] = randomChar;
				}else if(randomValue==18){
					randomChar="J";
					Array[i] = randomChar;
				}else if(randomValue==19){
					randomChar="K";
					Array[i] = randomChar;
				}else if(randomValue==20){
					randomChar="L";
					Array[i] = randomChar;
				}else if(randomValue==21){
					randomChar="M";
					Array[i] = randomChar;
				}else if(randomValue==22){
					randomChar="N";
					Array[i] = randomChar;
				}else if(randomValue==23){
					randomChar="O";
					Array[i] = randomChar;
				}else if(randomValue==24){
					randomChar="P";
					Array[i] = randomChar;
				}else if(randomValue==25){
					randomChar="Q";
					Array[i] = randomChar;
				}else if(randomValue==26){
					randomChar="R";
					Array[i] = randomChar;
				}else if(randomValue==27){
					randomChar="S";
					Array[i] = randomChar;
				}else if(randomValue==28){
					randomChar="T";
					Array[i] = randomChar;
				}else if(randomValue==29){
					randomChar="U";
					Array[i] = randomChar;
				}else if(randomValue==30){
					randomChar="V";
					Array[i] = randomChar;
				}else if(randomValue==31){
					randomChar="W";
					Array[i] = randomChar;
				}else if(randomValue==32){
					randomChar="X";
					Array[i] = randomChar;
				}else if(randomValue==33){
					randomChar="Y";
					Array[i] = randomChar;
				}else if(randomValue==34){
					randomChar="Z";
					Array[i] = randomChar;
				}else if(randomValue==35){
					randomChar="Z";
					Array[i] = randomChar;
				}else{
					randomChar="Z";
					Array[i] = randomChar;
				}
				
				System.out.println("랜덤 값"+ randomChar);
			}
	
		}

		String value = Array[0]+Array[1]+Array[2]+Array[3]+Array[4]+Array[5]+Array[6]+Array[7];
		System.out.println(value);
	}

}
