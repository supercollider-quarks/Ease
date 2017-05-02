a [Quark](http://supercollider-quarks.github.io/quarks/) for [SuperCollider](http://supercollider.github.io)

install it from within supercollider with the command `Quarks.install("Ease")`

# Ease
Easing and tweening classes for scserver and sclang. Ported from the Cinder C++ framework - original equations by Robert Penner

```supercollider
EaseGallery.new;
```

NOTE::
All these expects an input 0-1 as first argument to .value. If you give it out-of-range values the behavior is undefined.
::

![overview](overview.png?raw=true "overview")

Classes
==

- EaseNone			easing equation for a simple linear tweening with no easing

# Quadratic

- **EaseInQuad** easing equation for a quadratic (t^2) ease-in, accelerating from zero velocity
- **EaseOutQuad** easing equation for a quadratic (t^2) ease-out, decelerating to zero velocity
- **EaseInOutQuad** easing equation for a quadratic (t^2) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInQuad** easing equation for a quadratic (t^2) ease-out/in, decelerating until halfway, then accelerating

# Cubic

- **EaseInCubic** easing equation function for a cubic (t^3) ease-in, accelerating from zero velocity
- **EaseOutCubic** easing equation for a cubic (t^3) ease-out, decelerating to zero velocity
- **EaseInOutCubic** easing equation for a cubic (t^3) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInCubic** easing equation for a cubic (t^3) ease-out/in, decelerating until halfway, then accelerating

# Quartic

- **EaseInQuart** easing equation for a quartic (t^4) ease-in, accelerating from zero velocity
- **EaseOutQuart** easing equation for a quartic (t^4) ease-out, decelerating to zero velocity
- **EaseInOutQuart** easing equation for a quartic (t^4) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInQuart** easing equation for a quartic (t^4) ease-out/in, decelerating until halfway, then accelerating

# Quintic

- **EaseInQuint** easing equation function for a quintic (t^5) ease-in, accelerating from zero velocity
- **EaseOutQuint** easing equation for a quintic (t^5) ease-out, decelerating to zero velocity
- **EaseInOutQuint** easing equation for a quintic (t^5) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInQuint** easing equation for a quintic (t^5) ease-out/in, decelerating until halfway, then accelerating

# Sine

- **EaseInSine** easing equation for a sinusoidal (sin(t)) ease-in, accelerating from zero velocity
- **EaseOutSine** easing equation for a sinusoidal (sin(t)) ease-out, decelerating from zero velocity
- **EaseInOutSine** easing equation for a sinusoidal (sin(t)) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInSine** easing equation for a sinusoidal (sin(t)) ease-out/in, decelerating until halfway, then accelerating

# Exponential

- **EaseInExpo** easing equation for an exponential (2^t) ease-in, accelerating from zero velocity
- **EaseOutExpo** easing equation for an exponential (2^t) ease-out, decelerating from zero velocity
- **EaseInOutExpo** easing equation for an exponential (2^t) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInExpo** easing equation for an exponential (2^t) ease-out/in, decelerating until halfway, then accelerating

# Circular

- **EaseInCirc** easing equation for a circular (sqrt(1-t^2)) ease-in, accelerating from zero velocity
- **EaseOutCirc** easing equation for a circular (sqrt(1-t^2)) ease-out, decelerating from zero velocity
- **EaseInOutCirc** easing equation for a circular (sqrt(1-t^2)) ease-in/out, accelerating until halfway, then decelerating
- **EaseOutInCirc** easing equation for a circular (sqrt(1-t^2)) ease-out/in, decelerating until halfway, then accelerating

# Bounce

- **EaseInBounce(a)** easing equation for a bounce (exponentially decaying parabolic bounce) ease-in, accelerating from zero velocity. the \a parameter controls overshoot, the default producing a 10% overshoot
- **EaseOutBounce(a)** easing equation for a bounce (exponentially decaying parabolic bounce) ease-out, decelerating from zero velocity. the \a parameter controls overshoot, the default producing a 10% overshoot
- **EaseInOutBounce(a)** easing equation for a bounce (exponentially decaying parabolic bounce) ease-in/out, accelerating until halfway, then decelerating. the \a parameter controls overshoot, the default producing a 10% overshoot
- **EaseOutInBounce(a)** easing equation for a bounce (exponentially decaying parabolic bounce) ease-out/in, decelerating until halfway, then accelerating. the \a parameter controls overshoot, the default producing a 10% overshoot

# Back

- **EaseInBack(a)** easing equation for a back (overshooting cubic easing: (a+1)*t^3 - a*t^2) ease-in, accelerating from zero velocity. the \a parameter controls overshoot, the default producing a 10% overshoot
- **EaseOutBack(a)** easing equation for a back (overshooting cubic easing: (a+1)*t^3 - a*t^2) ease-out, decelerating from zero velocity. the \a parameter controls overshoot, the default producing a 10% overshoot
- **EaseInOutBack(a)** easing equation for a back (overshooting cubic easing: (a+1)*t^3 - a*t^2) ease-in/out, accelerating until halfway, then decelerating. the \a parameter controls overshoot, the default producing a 10% overshoot
- **EaseOutInBack(a)** easing equation for a back (overshooting cubic easing: (a+1)*t^3 - a*t^2) ease-out/in, decelerating until halfway, then accelerating. the \a parameter controls overshoot, the default producing a 10% overshoot

# Elastic

- **EaseInElastic(a, p)** easing equation for an elastic (exponentially decaying sine wave) ease-in, accelerating from zero velocity. the \a parameter is amplitude and \p is period.
- **EaseOutElastic(a, p)** easing equation for an elastic (exponentially decaying sine wave) ease-out, decelerating from zero velocity. the \a parameter is amplitude and \p is period.
- **EaseInOutElastic(a, p)** easing equation for an elastic (exponentially decaying sine wave) ease-in/out, accelerating until halfway, then decelerating. the \a parameter is amplitude and \p is period.
- **EaseOutInElastic(a, p)** easing equation for an elastic (exponentially decaying sine wave) ease-out/in, decelerating until halfway, then accelerating. the \a parameter is amplitude and \p is period.

# Atan

- **EaseInAtan(a)** easing equation for an atan ease-in, accelerating from zero velocity. the \a parameter is curvature.
- **EaseOutAtan(a)** easing equation for an atan ease-out, decelerating from zero velocity. the \a parameter is curvature.
- **EaseInOutAtan(a)** easing equation for an atan ease-in/out, accelerating until halfway, then decelerating. the \a parameter is curvature.


basic usage
==

```supercollider
e= EaseInAtan(15);
e.value(0)	//0 at the start
e.value(0.5)	//what is the value in the middle of the curve
e.value(1)	//1 at the end

//this can also be written like this to save us from storing the ease object in a variable
EaseInAtan.value(0.5)

//or shorter
EaseInAtan.(0.5)

//to set the curvature you give a second argument
EaseInAtan.(0.5, 10)

//or in the other notation
e= EaseInAtan(10)
e.value(0.5)


//--ramping
a= (0..100)/100;	//an array with 100 values 0.0-1.0
a.collect{|t| EaseInQuad.(t)}.plot;
a.collect{|t| EaseOutQuad.(t)}.plot;
a.collect{|t| EaseInOutQuad.(t)}.plot;


//--similar in sclang and inside synthdefs
s.boot
{SinOsc.ar(EaseInOutExpo.kr(MouseX.kr)*500+500, 0, 0.1)}.play
a.collect{|x| EaseInOutExpo.(x)}.plot


//--rates are flexibe when used inside synthdefs
{SinOsc.ar(EaseInAtan.(SinOsc.kr(1)).linlin(0, 1, 500, 5000), 0, 0.1)}.play	//becomes kr
{SinOsc.ar(EaseInAtan.kr(SinOsc.ar(1)).linlin(0, 1, 500, 5000), 0, 0.1)}.play	//kr with ar arg
{SinOsc.ar(EaseInAtan.ar(SinOsc.kr(1)).linlin(0, 1, 500, 5000), 0, 0.1)}.play	//ar with kr arg


//--nesting
a= (0..100)/100;	//an array with 100 values 0.0-1.0
a.collect{|t| EaseInAtan.(EaseInAtan.(t))}.plot


//--creating an object style
a= (0..100)/100;	//an array with 100 values 0.0-1.0
e= EaseInAtan(3);
f= EaseInAtan(30);
a.collect{|t| [e.(t), f.(t)]}.plot


//even this works...
e.(a).plot



//--use mouse to test
s.boot
a= {SinOsc.ar(EaseInOutQuint.ar(LFSaw.ar(MouseX.kr(1, 9, 1)).range(0, 1)).linexp(0, 1, 400, 800), 0, 0.1)}.play
a.free
a= {SinOsc.ar(EaseOutInExpo.ar(LFSaw.ar(MouseX.kr(1, 9, 1)).range(0, 1)).linexp(0, 1, 400, 800), 0, 0.1)}.play
a.free
a= {SinOsc.ar(EaseInAtan.ar(LFSaw.ar(MouseX.kr(1, 9, 1)).range(0, 1)).linexp(0, 1, 400, 800), 0, 0.1)}.play
a.free
a= {SinOsc.ar(EaseOutInElastic.ar(LFSaw.ar(MouseX.kr(1, 9, 1)).range(0, 1), MouseY.kr(1, 9, 1)).linexp(0, 1, 400, 800), 0, 0.1)}.play
a.free
a= {SinOsc.ar(EaseInBounce.ar(LFSaw.ar(MouseX.kr(1, 9, 1)).range(0, 1), MouseY.kr(1, 9, 1)).linexp(0, 1, 400, 800), 0, 0.1)}.play
a.free
```
