

public class Modulator {
	//BPSK modulation - 2PSK
	
/*	private float previousSymbol;
	private float currentSymbol;
	private float nextSymbol;*/
	public boolean [] inputBitstream;
	
	int psk_sr=700,psk_lcycle=70;
	
	
	
	//char bd_4signal[9];
	int c_hz=20, c_amplitude=25, sr =4000;
	float c_frequency;
	int c_angle;
	int c_phase;
	int c_lcycle=400,temp;
	float[] sine_value = new float[1000];
	
	PSK psk = new PSK(c_frequency, c_angle, c_angle, c_phase, c_phase,c_amplitude,0);
	
	
	
	public void convertBitsToSymbols(Boolean [] bitsample){
		
	}
	
	void calc_psk_sinewave(int ph01)
	{
		float frequency;
		frequency = (2 * (float)Math.PI * c_hz)/psk_sr;
		for (int t = 0; t<psk_lcycle;t++)
			psk.sine_value[t] = (float) (psk.amp * (Math.sin((float)(frequency*t+ ph01))));
	}
	
	public void calc_sinewave()
	{
		c_frequency = (float)(2 * Math.PI * c_hz)/sr;
		for (int t = 0; t<c_lcycle;t++)
			sine_value[t] = (float) (c_amplitude * (Math.sin((float)(c_frequency*t+ c_phase))));
	}
	
/*	void create_simple_wave()
	{
		int x=40,y=200,x1,y1;
		setcolor(2);
		setlinestyle(0,0,3);
		for(int i=0;i<c_lcycle;i++)
		{
			x1=x+i;
			if(c_sine_value[i] >= 0)
				y1=y-c_sine_value[i];
			else
				y1=y+((-1)*c_sine_value[i]);
			line(x1,y1,x1,y1);
		}
	}*/
	
	void psk_main(Boolean[] input)
	{
		psk.x=32;
		for (int i = 0;i<input.length;i++)
		{
			if (!input[i]) //if zero
			{
				calc_psk_sinewave(psk.phase0);
				create_psk_waves();
			}
			else
			{
				calc_psk_sinewave(psk.phase1);
				create_psk_waves();
			}
		}
	}
	////////////////////////////////////////////////////
	void create_psk_waves()
	{
		int y=200,x1 = 0,y1;
		for(int i=0;i<psk_lcycle;i++)
		{
			x1=psk.x+i;
			if(psk.sine_value[i] >= 0)
			y1=y-(int)psk.sine_value[i];
			else
			y1=y+((-1)*(int)psk.sine_value[i]);
			//line(x1,y1,x1,y1);
		}
		psk.x=x1;
	}
	
	
	public static void main(String [ ] args){
		Modulator mod = new Modulator();
		Boolean [] testbits = {true, true, false, false, false};
		/*for (int i = 0; i<testbits.length; i++){
			mod.inputBitstream[i] = testbits[i];
		}*/
		for(int i = 0 ; i<5; i++)
			System.out.printf("val: %b", testbits[i]);
		mod.psk_main(testbits);
		for(int i = 0 ; i<mod.psk.sine_value.length; i++)
			System.out.printf("val: %.2f", mod.psk.sine_value[i]);
	}


}
