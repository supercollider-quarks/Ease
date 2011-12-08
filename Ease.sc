//--redFrik dec2011
//code ported and adapted to scserver+sclang from the Cinder C++ framework (see Easing.h)


/*
 Copyright (c) 2011, The Cinder Project, All rights reserved.
 This code is intended for use with the Cinder C++ library: http://libcinder.org

 Redistribution and use in source and binary forms, with or without modification, are permitted provided that
 the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and
	the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
	the following disclaimer in the documentation and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 POSSIBILITY OF SUCH DAMAGE.

Documentation and easeOutIn* algorithms adapted from Qt: http://qt.nokia.com/products/

Disclaimer for Robert Penner's Easing Equations license:
TERMS OF USE - EASING EQUATIONS
Open source under the BSD License.

Copyright © 2001 Robert Penner
All rights reserved.

Disclaimer for Copyright (c) 2011, The Cinder Project, All rights reserved.
Copyright (c) 2011, The Cinder Project, All rights reserved.
 
 
Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

	* Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
	* Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
	* Neither the name of the author nor the names of contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/





Ease {	//abstract class
	*ar {|t ...args| if(t.rate=='audio', {^this.new(t, *args)}, {^this.new(K2A.ar(t), *args)})}
	*kr {|t ...args| ^this.new(A2K.kr(t), *args)}
}

EaseNone : Ease {
	*new {|t| ^t}
}

//--Quadratic

EaseInQuad : Ease {
	*new {|t| ^t*t}
}
EaseOutQuad : Ease {
	*new {|t| ^(0-t)*(t-2)}
}
EaseInOutQuad : Ease {
	*new {|t| t= t*2; ^if(t<1, 0.5*t*t, -0.5*(t-1*(t-3)-1))}
}
EaseOutInQuad : Ease {
	*new {|t| ^if(t<0.5, EaseOutQuad(t*2)*0.5, EaseInQuad(2*t-1)*0.5+0.5)}
}

//--Cubic

EaseInCubic : Ease {
	*new {|t| ^t*t*t}
}
EaseOutCubic : Ease {
	*new {|t| t= t-1; ^(t*t*t)+1}
}
EaseInOutCubic : Ease {
	*new {|t| t= t*2; ^if(t<1, 0.5*t*t*t, t= t-2; 0.5*(t*t*t+2))}
}
EaseOutInCubic : Ease {
	*new {|t| ^if(t<0.5, EaseOutCubic(2*t)/2, EaseInCubic(2*t-1)/2+0.5)}
}

//--Quartic

EaseInQuart : Ease {
	*new {|t| ^t*t*t*t}
}
EaseOutQuart : Ease {
	*new {|t| t= t-1; ^0-(t*t*t*t-1)}
}
EaseInOutQuart : Ease {
	*new {|t| var t2; t= t*2; t2= t-2; ^if(t<1, 0.5*t*t*t*t, -0.5*(t2*t2*t2*t2-2))}
}
EaseOutInQuart : Ease {
	*new {|t| ^if(t<0.5, EaseOutQuart(2*t)/2, EaseInQuart(2*t-1)/2+0.5)}
}

//--Quintic

EaseInQuint : Ease {
	*new {|t| ^t*t*t*t*t}
}
EaseOutQuint : Ease {
	*new {|t| t= t-1; ^t*t*t*t*t+1}
}
EaseInOutQuint : Ease {
	*new {|t| var t2; t= t*2; t2= t-2; ^if(t<1, 0.5*t*t*t*t*t, 0.5*(t2*t2*t2*t2*t2+2))}
}
EaseOutInQuint : Ease {
	*new {|t| ^if(t<0.5, EaseOutQuint(2*t)/2, EaseInQuint(2*t-1)/2+0.5)}
}

//--Sine

EaseInSine : Ease {
	*new {|t| ^0-cos(t*pi/2)+1}
}
EaseOutSine : Ease {
	*new {|t| ^sin(t*pi/2)}
}
EaseInOutSine : Ease {
	*new {|t| ^-0.5*(cos(pi*t)-1)}
}
EaseOutInSine : Ease {
	*new {|t| ^if(t<0.5, EaseOutSine(2*t)/2, EaseInSine(2*t-1)/2+0.5)}
}

//--Exponential

EaseInExpo : Ease {
	*new {|t| ^pow(2, 10*(t-1))}
}
EaseOutExpo : Ease {
	*new {|t| ^if(t==1, {1}, {0-pow(2, -10*t)+1})}
	*ar {|t| ^Select.ar(BinaryOpUGen('==', t, 1), [DC.ar(0)-pow(2, -10*t)+1, DC.ar(1)])}
	*kr {|t| ^Select.kr(BinaryOpUGen('==', t, 1), [0-pow(2, -10*t)+1, DC.kr(1)])}
}
EaseInOutExpo : Ease {
	*new {|t|
		^if(t==0, {
			0;
		}, {
			if(t==1, {
				1;
			}, {
				t= t*2;
				if(t<1, {
					0.5*pow(2, 10*(t-1));
				}, {
					0.5*(0-pow(2, -10*(t-1))+2);
				});
			});
		});
	}
	*ar {|t|
		var t2= t*2;
		^Select.ar(BinaryOpUGen('==', t, 0), [
			Select.ar(BinaryOpUGen('==', t, 1), [
				if(t2<1, DC.ar(0.5)*pow(2, 10*(t2-1)), DC.ar(0.5)*(0-pow(2, -10*(t2-1))+2)),
				DC.ar(1)
			]),
			DC.ar(0)
		]);
	}
	*kr {|t|
		var t2= t*2;
		^Select.kr(BinaryOpUGen('==', t, 0), [
			Select.kr(BinaryOpUGen('==', t, 1), [
				if(t2<1, 0.5*pow(2, 10*(t2-1)), 0.5*(0-pow(2, -10*(t2-1))+2)),
				DC.kr(1)
			]),
			DC.kr(0)
		]);
	}
}
EaseOutInExpo : Ease {
	*new {|t| ^if(t<0.5, EaseOutExpo(2*t)/2, EaseInExpo(2*t-1)/2+0.5)}
}

//--Circular

EaseInCirc : Ease {
	*new {|t| ^0-(sqrt(1-(t*t))-1)}
}
EaseOutCirc : Ease {
	*new {|t| t= t-1; ^sqrt(1-(t*t))}
}
EaseInOutCirc : Ease {
	*new {|t| var t2; t= t*2; t2= t-2; ^if(t<1, -0.5*(sqrt(1-(t*t))-1), 0.5*(sqrt(1-(t2*t2))+1))}
}
EaseOutInCirc : Ease {
	*new {|t| ^if(t<0.5, EaseOutCirc(2*t)/2, EaseInCirc(2*t-1)/2+0.5)}
}

//--Bounce

EaseBounce : Ease {	//abstract class
	*prNew {|t, c, a|
		^if(t==1, {
			c;
		}, {
			if(t<(4/11), {
				c*7.5625*t*t;
			}, {
				if(t<(8/11), {
					t= t-(6/11);
					(0-a)*(1-(7.5625*t*t+0.75))+c;
				}, {
					if(t<(10/11), {
						t= t-(9/11);
						(0-a)*(1-(7.5625*t*t+0.9375))+c;
					}, {
						t= t-(21/22);
						(0-a)*(1-(7.5625*t*t+0.984375))+c;
					});
				});
			});
		});
	}
	*prAr {|t, c, a|
		var t2= t-(6/11);
		var t3= t-(9/11);
		var t4= t-(21/22);
		^Select.ar(BinaryOpUGen('==', t, 1), [
			Select.ar(t<(4/11), [
				Select.ar(t<(8/11), [
					Select.ar(t<(10/11), [
						(0-a)*(1-(7.5625*t4*t4+0.984375))+c,
						(0-a)*(1-(7.5625*t3*t3+0.9375))+c
					]),
					(0-a)*(1-(7.5625*t2*t2+0.75))+c
				]),
				c*7.5625*t*t
			]),
			c
		]);
	}
	*prKr {|t, c, a|
		var t2= t-(6/11);
		var t3= t-(9/11);
		var t4= t-(21/22);
		^Select.kr(BinaryOpUGen('==', t, 1), [
			Select.kr(t<(4/11), [
				Select.kr(t<(8/11), [
					Select.kr(t<(10/11), [
						(0-a)*(1-(7.5625*t4*t4+0.984375))+c,
						(0-a)*(1-(7.5625*t3*t3+0.9375))+c
					]),
					(0-a)*(1-(7.5625*t2*t2+0.75))+c
				]),
				c*7.5625*t*t
			]),
			c
		]);
	}
}
EaseInBounce : EaseBounce {		//a= overshoot
	*new {|t, a= 1.70158| ^1-super.prNew(1-t, 1, a)}
	*ar {|t, a= 1.70158|
		if(t.rate=='audio', {
			^1-super.prAr(1-t, DC.ar(1), a);
		}, {
			^1-super.prAr(K2A.ar(1-t), DC.ar(1), a);
		});
	}
	*kr {|t, a= 1.70158| ^1-super.prKr(A2K.kr(1-t), 1, a)}
}
EaseOutBounce : EaseBounce {		//a= overshoot
	*new {|t, a= 1.70158| ^super.prNew(t, 1, a)}
	*ar {|t, a= 1.70158|
		if(t.rate=='audio', {
			^super.prAr(t, DC.ar(1), a)
		}, {
			^super.prAr(K2A.ar(t), DC.ar(1), a)
		});
	}
	*kr {|t, a= 1.70158| ^super.prKr(A2K.kr(t), 1, a)}
}
EaseInOutBounce : EaseBounce {		//a= overshoot
	*new {|t, a= 1.70158|
		^if(t<0.5, {
			EaseInBounce(2*t, a)/2
		}, {
			if(t==1, {
				1;
			}, {
				EaseOutBounce(2*t-1, a)/2+0.5;
			});
		});
	}
	*ar {|t, a= 1.70158|
		^if(t<0.5,
			EaseInBounce.ar(2*t, a)/2,
			Select.ar(BinaryOpUGen('==', t, 1), [
				EaseOutBounce.ar(2*t-1, a)/2+0.5,
				DC.ar(1)
			])
		);
	}
	*kr {|t, a= 1.70158|
		^if(t<0.5,
			EaseInBounce.kr(2*t, a)/2,
			Select.kr(BinaryOpUGen('==', t, 1), [
				EaseOutBounce.kr(2*t-1, a)/2+0.5,
				DC.kr(1)
			])
		);
	}
}
EaseOutInBounce : EaseBounce {		//a= overshoot
	*new {|t, a= 1.70158|
		^if(t<0.5, {
			super.prNew(t*2, 0.5, a);
		}, {
			1-super.prNew(2-(2*t), 0.5, a);
		});
	}
	*ar {|t, a= 1.70158|
		^if(t<0.5,
			super.prAr(t*DC.ar(2), DC.ar(0.5), a),
			1-super.prAr(DC.ar(2)-(2*t), DC.ar(0.5), a)
		);
	}
	*kr {|t, a= 1.70158|
		^if(t<0.5,
			super.prKr(t*DC.kr(2), 0.5, a),
			1-super.prKr(DC.kr(2)-(2*t), 0.5, a)
		);
	}
}

//--Back

EaseInBack : Ease {		//a= overshoot
	*new {|t, a= 1.70158| ^t*t*((a+1)*t-a)}
}
EaseOutBack : Ease {		//a= overshoot
	*new {|t, a= 1.70158| t= t-1; ^t*t*((a+1)*t+a)+1}
}
EaseInOutBack : Ease {		//a= overshoot
	*new {|t, a= 1.70158|
		var t2, a2; t= t*2; t2= t-2; a2= a*1.525;
		^if(t<1, 0.5*(t*t*((a2+1)*t-a2)), 0.5*(t2*t2*((a2+1)*t2+a2)+2));
	}
}
EaseOutInBack : Ease {		//a= overshoot
	*new {|t, a= 1.70158| ^if(t<0.5, EaseOutBack(2*t, a)/2, EaseInBack(2*t-1, a)/2+0.5)}
}

//--Elastic

EaseInElastic : Ease {		//a= amplitude, p= period
	*prNew {|t, b, c, d, a, p|
		var t_adj, s;
		^if(t==0, {
			b;
		}, {
			t_adj= t/d;
			if(t_adj==1, {
				b+c;
			}, {
				if(a<abs(c), {
					a= c;
					s= p/4;
				}, {
					s= p/2pi*asin(c/a);
				});
				t_adj= t_adj-1;
				0-(a*pow(2, 10*t_adj)*sin((t_adj*d-s)*2pi/p))+b;
			});
		});
	}
	*prAr {|t, b, c, d, a, p|
		var t_adj, t_adj2;
		t_adj= t/d;
		t_adj2= t_adj-1;
		^Select.ar(BinaryOpUGen('==', t, 0), [
			Select.ar(BinaryOpUGen('==', t_adj, 1), [
				if(a<abs(c),
					0-(c*pow(2, 10*t_adj2)*sin((t_adj2*d-(p/4))*2pi/p))+b,
					0-(a*pow(2, 10*t_adj2)*sin((t_adj2*d-(p/2pi*asin(c/a)))*2pi/p))+b
				),
				b+c
			]),
			b
		]);
	}
	*prKr {|t, b, c, d, a, p|
		var t_adj, t_adj2;
		t_adj= t/d;
		t_adj2= t_adj-1;
		^Select.kr(BinaryOpUGen('==', t, 0), [
			Select.kr(BinaryOpUGen('==', t_adj, 1), [
				if(a<abs(c),
					0-(c*pow(2, 10*t_adj2)*sin((t_adj2*d-(p/4))*2pi/p))+b,
					0-(a*pow(2, 10*t_adj2)*sin((t_adj2*d-(p/2pi*asin(c/a)))*2pi/p))+b
				),
				b+c
			]),
			b
		]);
	}
	*new {|t, a= 1, p= 1| ^this.prNew(t, 0, 1, 1, a, p)}
	*ar {|t, a= 1, p= 1| ^this.prAr(t, DC.ar(0), 1, 1, a, p)}
	*kr {|t, a= 1, p= 1| ^this.prKr(t, 0, 1, 1, a, p)}
}
EaseOutElastic : Ease {		//a= amplitude, p= period
	*prNew {|t, b, c, d, a, p|
		var s;
		^if(t==0, {
			0;
		}, {
			if(t==1, {
				c;
			}, {
				if(a<c, {
					a= c;
					s= p/4;
				}, {
					s= p/2pi*asin(c/a);
				});
				a*pow(2, -10*t)*sin((t-s)*2pi/p)+c;
			});
		});
	}
	*prAr {|t, b, c, d, a, p|
		^Select.ar(BinaryOpUGen('==', t, 0), [
			Select.ar(BinaryOpUGen('==', t, 1), [
				if(a<c,
					c*pow(2, -10*t)*sin((t-(p/4))*2pi/p)+c,
					a*pow(2, -10*t)*sin((t-(p/2pi*asin(c/a)))*2pi/p)+c
				),
				c
			]),
			DC.ar(0)
		]);
	}
	*prKr {|t, b, c, d, a, p|
		^Select.kr(BinaryOpUGen('==', t, 0), [
			Select.kr(BinaryOpUGen('==', t, 1), [
				if(a<c,
					c*pow(2, -10*t)*sin((t-(p/4))*2pi/p)+c,
					a*pow(2, -10*t)*sin((t-(p/2pi*asin(c/a)))*2pi/p)+c
				),
				c
			]),
			0
		]);
	}
	*new {|t, a= 1, p= 1| ^this.prNew(t, 0, 1, 1, a, p)}
	*ar {|t, a= 1, p= 1| ^this.prAr(t, 0, DC.ar(1), 1, a, p)}
	*kr {|t, a= 1, p= 1| ^this.prKr(t, 0, 1, 1, a, p)}
}
EaseInOutElastic : Ease {		//a= amplitude, p= period
	*new {|t, a= 1, p= 1|
		var s;
		^if(t==0, {
			0;
		}, {
			t= t*2;
			if(t==2, {
				1;
			}, {
				if(a<1, {
					a= 1;
					s= p/4;
				}, {
					s= p/2pi*asin(1/a);
				});
				if(t<1, {
					-0.5*(a*pow(2, 10*(t-1))*sin((t-1-s)*2pi/p));
				}, {
					a*pow(2, -10*(t-1))*sin((t-1-s)*2pi/p)*0.5+1;
				});
			});
		});
	}
	*ar {|t, a= 1, p= 1|
		var t2= t*DC.ar(2);
		var a2= a.min(1);
		^Select.ar(BinaryOpUGen('==', t, 0), [
			Select.ar(BinaryOpUGen('==', t2, 2), [
				if(t2<1,
					-0.5*(a2*pow(2, 10*(t2-1))*sin((t2-1-(p/2pi*asin(1/a2)))*2pi/p)),
					a2*pow(2, -10*(t2-1))*sin((t2-1-(p/2pi*asin(1/a2)))*2pi/p)*0.5+1
				),
				DC.ar(1)
			]),
			DC.ar(0)
		]);
	}
	*kr {|t, a= 1, p= 1|
		var t2= t*2;
		var a2= a.min(1);
		^Select.kr(BinaryOpUGen('==', t, 0), [
			Select.kr(BinaryOpUGen('==', t2, 2), [
				if(t2<1,
					-0.5*(a2*pow(2, 10*(t2-1))*sin((t2-1-(p/2pi*asin(1/a2)))*2pi/p)),
					a2*pow(2, -10*(t2-1))*sin((t2-1-(p/2pi*asin(1/a2)))*2pi/p)*0.5+1
				),
				1
			]),
			0
		]);
	}
}
EaseOutInElastic : Ease {		//a= amplitude, p= period
	*new {|t, a= 1, p= 1|
		^if(t<0.5, {
			EaseOutElastic.prNew(t*2, 0, 0.5, 1, a, p);
		}, {
			EaseInElastic.prNew(2*t-1, 0.5, 0.5, 1, a, p);
		});
	}
	*ar {|t, a= 1, p= 1|
		^if(t<0.5,
			EaseOutElastic.prAr(t*2, 0, DC.ar(0.5), 1, a, p),
			EaseInElastic.prAr(2*t-1, DC.ar(0.5), DC.ar(0.5), DC.ar(1), a, p)
		);
	}
	*kr {|t, a= 1, p= 1|
		if(t<0.5, {
			^EaseOutElastic.prKr(t*2, 0, 0.5, 1, a, p);
		}, {
			^EaseInElastic.prKr(2*t-1, 0.5, 0.5, 1, a, p);
		});
	}
}

//--Atan

EaseInAtan : Ease {
	*new {|t, a= 15| var m= atan(a); ^atan((t-1)*a)/m+1}
}
EaseOutAtan : Ease {
	*new {|t, a= 15| var m= atan(a); ^atan(t*a)/m}
}
EaseInOutAtan : Ease {
	*new {|t, a= 15| var m= atan(0.5*a); ^atan((t-0.5)*a)/(2*m)+0.5}
}
