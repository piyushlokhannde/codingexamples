package main.java.piyush.romannumerical;

/**
 *Defines the roman numberical enum with thier value.
 *
 */
public enum RomanNumeral {
		
		I(1) {
			@Override
			public String toString() {				
				return "I";
			}
		},
		
		V(5) {
			@Override
			public String toString() {				
				return "V";
			}
		},
		X(10) {
			@Override
			public String toString() {				
				return "X";
			}
		},
		L(50) {
			@Override
			public String toString() {				
				return "L";
			}
		},
		C(100) {
			@Override
			public String toString() {				
				return "C";
			}
		},
		
		D(500) {
			@Override
			public String toString() {				
				return "D";
			}
		},
		M(1000) {
			@Override
			public String toString() {				
				return "M";
			}
		};
		
		private int value;
		
		public int  getvalue(){
			return this.value;
		}
		
		private RomanNumeral(int valueIn) {
			this.value = valueIn;
		}
	}