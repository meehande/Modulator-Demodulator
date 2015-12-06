
public class PSK {

	float[] sine_value = new float[1000];
	float frequency;
	int ang1,ang0;
	int phase0,phase1;
	int amp;
	int x;
	
	public PSK(){
		frequency = 0.0f;
		ang1 = 0;
		ang0 = 0;
		phase0 = 0;
		phase1 = 0;
		amp = 0;
		x = 0;
		
	}
	public PSK(float frequency, int ang1, int ang0, int phase0, int phase1, int amp, int x){
		this.frequency = frequency;
		this.ang1 = ang1;
		this.ang0 = ang0;
		this.phase0 = phase0;
		this.phase1 = phase1;
		this.amp  = amp;
		this.x = x;
	}
	
	public void setAmp(int a){
		amp = a;
	}
	public int getAmp(){
		return amp;
	}
	public void setAng1(int a){
		ang1 = a;
	}
	public int getAng1(){
		return ang1;
	}
	public void setAng0(int a){
		ang0 = a;
	}
	public int getAng0(){
		return ang0;
	}
	public void setPhase0(int a){
		phase0 = a;
	}
	public int getPhase0(){
		return phase0;
	}
	public void setPhase1(int a){
		phase1 = a;
	}
	public int getPhase1(){
		return phase0;
	}
	public void setFrequency(float a){
		frequency = a;
	}
	public float getFrequency(){
		return frequency;
	}
	public void setSineVal(float[] a){
		sine_value = a;
	}
	public float [] getSineVal(){
		return sine_value;
	}
	public void setX(int a){
		x = a;
	}
	public int getX(){
		return x;
	}
}
