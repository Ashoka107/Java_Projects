package com.bitwise.MarsRover;

public enum Direction {

	N(0,1){
		@Override
		public Direction left(){
			return W;
		}
		@Override
		public Direction right(){
			return E;
		}
	},
	S(0,-1){
		@Override
		public Direction left(){
			return E;
		}
		@Override
		public Direction right(){
			return W;
		}
	},
	E(1,0){
		@Override
		public Direction left(){
			return N;
		}
		@Override
		public Direction right(){
			return S;
		} 
	},
	W(-1,0){
		@Override
		public Direction left(){
			return S;
		}
		@Override
		public Direction right(){
			return N;
		}
	};
	
	private int stepSizeOnXAxis;
	private int stepSizeOnYAxis;
	
    Direction(final int stepSizeOnXAxis,final int stepSizeOnYAxis){
		this.stepSizeOnXAxis=stepSizeOnXAxis;
		this.stepSizeOnYAxis=stepSizeOnYAxis;
	}
    public int stepSizeOnXAxis(){
    	System.out.println(this.stepSizeOnXAxis);
    	return this.stepSizeOnXAxis;
    }
    public int stepSizeOnYAxis(){
    	System.out.println(this.stepSizeOnYAxis);
    	return this.stepSizeOnYAxis;
    }
    abstract Direction left();
    abstract Direction right();
}
