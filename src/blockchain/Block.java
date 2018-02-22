package blockchain;

import java.util.Date;

/*1*/
public class Block {

	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	/*9*/
	private int nonce = 0;
	
	
	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		/*4*/
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
		
	}
	
	/*3*/
	//Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				/*12*/
				/**/Integer.toString(nonce) +
				
				data 
				);
		return calculatedhash;
	}
	
	/*10*/
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
		
		/* 13
		System.out.println(difficulty);
		System.out.println(hash);
		System.out.println(hash.substring( 0, difficulty));
		System.out.println(target);
		*/
		
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
			
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
	
	
	
}