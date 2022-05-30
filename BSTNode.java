public class BSTNode {
	private BSTNode left; 
	private BSTNode right; 
	private Dollar data;
	
	public BSTNode (Dollar data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode getLeft(){
		return left;
	}
	
	public BSTNode getRight(){
		return right;
	}
	
	public void setLeft(BSTNode left){
		left = left;
	}
	
	public void setRight(BSTNode right){
		right = right;
	}
	
	public Dollar getData(){
		return data;
	}
	
	
	
	

}
