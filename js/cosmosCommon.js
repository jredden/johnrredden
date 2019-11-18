/**
 * collection of objects common to random or known entry point into cosmos space simulation
 */

/**
 * not static, has to be instantiated
 */
var keyValuePair  = (function(){
	// private
	var key;
	var value;
	
	return{
		setKey : function(s_key){
			key = s_key;
		},
		setValue: function(s_value){
			value = s_value;
		},
		getKey : function(){
			return key;
		},
		getValue : function(){
			return value;
		},
		logPrint: function(){
			console.log("KEY:"+key+" VALUE:"+value);
		}
	}
	
});

/*
 *  2D 
 */
var point = (function(){
	var xcoordinate;
	var ycoordinate;
	return{
		setXandY: function(xcoord, ycoord){
			xcoordinate = xcoord;
			ycoordinate = ycoord;
		},
		getX: function(){
			return xcoordinate;
		},
		getY: function(){
			return ycoordinate;
		},
		logPrint(){
			console.log("XCOORDINATE:"+xcoordinate+ " YCOORDINATE:"+ycoordinate);
		}
	}
});

var circle = (function(){
	var left;
	var right;
	var top;
	var bottom;
	var n_radius;
	var n_xDim;
	var n_yDim;
	
	return {
		construct: function(xDim, yDim, radius){
			n_radius = radius;
			n_xDim = xDim;
			n_yDim = yDim;
			left = xDim - radius;
			right = xDim + radius;
			top = yDim - radius;
			bottom = yDim + radius;
		},
		fetchLeft(){
			return left;
		},
		fetchRight(){
			return right;
		},
		fetchTop(){
			return top;
		},
		fetchBottom(){
			return bottom;
		}
	}
});

/**
 * a 2D vector
 */
var relativeSystemVector  = (function(){
	
	var scalarX;
	var scalarY;
	
	return {
		setScalarXandY: function(sX, sY){
			scalarX = sX;
			scalarY = sY;
		},
		getScalarX: function(){
			return scalarX;
		},
		getScalarY: function(){
			return scalarY;
		}
	}
	
});

/**
 * a point from an angle and a magnitude
 */
var scaledXandY = (function(){
	
	return{
		scaleToAngle: function(angleInRadians, magnitude){
			var cosAngle = Math.cos(angleInRadians);
			var sinAngle = Math.sin(angleInRadians);
			var xcoordinate = cosAngle * magnitude;
			var ycoordinate = sinAngle * magnitude;
			var a_point = new point();
			a_point.setXandY(xcoordinate, ycoordinate);
			return a_point;
		}
	}
	
})();

/**
 * attaches a method to two bounds
 */
var descriminator = (function (){
	var e1;
	var e2;
	var method
	return{
		setBounds: function(first, second, o_method){
			e1 = first;
			e2 = second;
			method = o_method;
		},
	
		getFirstBound: function(){
			return e1;
		},
	
		getSecondBound: function(){
			return e2;
		},
		getMethod: function(){
			return method;
		}
	}
});


/**
 * builds array of arrays holding ordered pairs
 */
var orderedPairToArray = (function (){
	return{
		getOrderedPair: function (oneString){
			var result = [];
			var stars = [];
			
			var arrayOfUnsplitOrderedPairs = oneString.toString().split(";");

			for(var idex = 0; idex < arrayOfUnsplitOrderedPairs.length; idex++){
				kvPair = new keyValuePair();
				var kvArray = arrayOfUnsplitOrderedPairs[idex].split("=");
				kvPair.setKey(kvArray[0]);
				kvPair.setValue(kvArray[1]);
				// console.log("KVPAIR:"+kvPair.getKey()+"::"+kvPair.getValue());
				result.push(kvPair);
			}
			return result;
		}
	}
})();

/**
 * top object of a star system
 * view centric domain object
 * not "static" has to be instantiated
 */
var systemVizCentric = (function(){
	// private 
	var distanceToGalacticCentre;
	var uCoordinate;
	var vCoordinate;
	var systemName;
	var systemRename;
	
	// public
	return {
		setDistanceToGalacticCentre: function(distance){
			distanceToGalacticCentre = distance;
		},
		getDistanceToGalaticCentre: function(){
			return distanceToGalacticCentre;
		},
		setUCoordinate: function(ucoord){
			uCoordinate = ucoord;
		},
		getUCoordinate: function(){
			return uCoordinate;
		},
		setVCoordinate: function(vcoord){
			vCoordinate = vcoord;
		},
		getVCoordinate: function(){
			return vCoordinate;
		},
		setSystemName(name){
			systemName = name;
		},
		getSystemName(){
			return systemName;
		},
		setRename(rename){
			systemRename = rename;
		},
		getRename(){
			return systemRename;
		}
	}
});

/**
 * cluster of stars
 * view centric domain object
 * not "static" has to be instantiated
 */
var clusterVizCentric  = (function(){
	// private 
	var sub_cluster_description;
	var angle_in_radians_s;
	var distance_clust_virt_centre;
	var luminosity;
	var Name;
	var star_color;
	var star_size;
	var star_type;
	var system_name;
	var rename;
	
	// public
	return {
		setSubClusterDescription: function(sCDescription){
			sub_cluster_description = sCDescription;
		},
		getSubClusterDescription: function(){
			console.log("GETTING SUB CLUSTER DESCRIPTION:"+sub_cluster_description);
			return sub_cluster_description;
		},
		setAnglenInRadians: function(angInRadians){
			angle_in_radians_s = angInRadians;
		},
		getAnglenInRadians: function(){
			return angle_in_radians_s;
		},
		setDistanceClusterVirtCentre: function(distClustVirtCentre){
			distance_clust_virt_centre = distClustVirtCentre;
		},
		getDistanceClusterVirtCentre: function(){
			return distance_clust_virt_centre;
		},
		setLuminosity: function(lumin){
			luminosity= lumin;
		},
		getLuminosity: function(){
			return luminosity;
		},
		setStarName: function(SName){
			Name = SName;
		},
		getStarName: function(){
			return Name;
		},
		setStarColor: function(starColor){
			star_color = starColor;
		},
		getStarColor: function(){
			return star_color;
		},
		setStarSize: function(starSize){
			star_size = starSize;
		},
		getStarSize: function(){
			return star_size;
		},
		setStarType: function(starType){
			star_type = starType;
		},
		getStarType: function(){
			return star_type;
		},
		setSystemName: function(systemName){	// used to identify set of attributes
			system_name = systemName;
		},
		getSystemName: function(){
			return system_name;
		},
		setRename:function(s_rename){
			rename = s_rename;
		},
		getRename:function(){
			return rename;
		}
		
	}
});

/**
 * color and percentage of that color in the planets atmosphere
 */
var colorPercentageSet = (function (){
	var planarColor;
	var colorPercentage;
	
	return{
		setPlanarColor: function(color){
			planarColor = color;
		},
		setColorPercentage: function(percentage){
			colorPercentage = percentage;
		},
		getPlanarColor: function(){
			return planarColor;
		},
		getColorPercentage: function(){
			return colorPercentage;
		}
	}
});

/**
 * used in visualizing atmospheres
 */
var atmosphereSet  = (function (){
	var chemical;
	var percentage;
	var color;
	
	const visualSize = function(percentage){
		var y_size;
		sizeDictionary = new buckets.Dictionary();
		sizeDictionary.set(0, 6);
		sizeDictionary.set(1, 9);
		sizeDictionary.set(5, 18);
		sizeDictionary.set(10, 24);
		sizeDictionary.set(20, 30);
		sizeDictionary.set(30, 40);
		sizeDictionary.set(50, 50);
		sizeDictionary.set(60, 60);
		sizeDictionary.set(70, 70);
		sizeDictionary.set(101, 80);  // end mark value
		var ranges = sizeDictionary.keys();
		for(var idex = 0; idex < ranges.length; idex++){
			if(percentage >= ranges[idex] && percentage < ranges[idex+1]){
				y_size = sizeDictionary.get(ranges[idex]);
				break;
			}
		}
		return y_size;		
	}
	
	return{
		setChemical: function(chemicalName){
			chemical = chemicalName;
		},
		getChemical: function(){
			return chemical;
		},
		setPercentage: function(r_percentage){
			percentage = r_percentage;
		},
		getPercentage: function(){
			return percentage;
		},
		setColor: function(s_color){
			color = s_color;
		},
		getColor: function(){
			return color;
		},
		getYVisualSize: function(percentage){
			return visualSize(percentage);
		}
	}
});

/**
 * gradient object
 */
var gradientBuilder = (function (){
	var color;
	var gradientPercentage;	
	
	return{
		setColor: function(s_color){
			color = s_color;
		},
		getColor: function(){
			return color;
		},
		setGradientPercentage(n_gradientPercentage){
			gradientPercentage = n_gradientPercentage;
		},
		getGradientPercentage(){
			return gradientPercentage;
		}
	}
});

/**
 * visual centric object of a planetoid
 */
var planarVizCentric = (function (){
	
	var planarName;
	var planarDegree;  				// in radians
	var planarDistanceToPrimary;	// kilometers
	var planarTemperature; 			// Kelvin
	var planarRadius;				// kilometers
	var planarTempType;
	var planarSizeType;
	var planarPecentageWater;
	var planarRename;
	var planarColorsArray = [];
	var gradientsArray = [];
	
	
	
	return{
		setPlanarName: function(name){
			planarName = name;
		},
		getPlanarName: function(){
			return planarName;
		},
		setPlanarDegree: function(degree){
			planarDegree = degree;
		},
		getPlanarDegree: function(){
			return planarDegree;
		},
		setPlanarDistanceToPrimary: function(distance){
			planarDistanceToPrimary = distance;
		},
		getPlanarDistanceToPrimary: function(){
			return planarDistanceToPrimary;
		},
		setPlanarTemperature: function(temperature){
			planarTemperature = temperature;
		},
		getPlanarTemperature: function(){
			return planarTemperature;
		},
		setPlanarRadius: function(radius){
			planarRadius = radius;
		},
		getPlanarRadius: function(){
			return planarRadius;
		},
		setPlanarTempType: function(tempType){
			planarTempType = tempType;
		},
		getPlanarTempType: function(){
			return planarTempType;
		},
		setPlanarSizeType: function(sizeType){
			planarSizeType = sizeType;
		},
		getPlanarSizeType: function(){
			return planarSizeType;
		},
		addColorPercentage: function(colorPercentage){
			planarColorsArray.push(colorPercentage);
		},
		getColorPercentage: function(){
			return planarColorsArray;
		},
		setPlanarPercentWater(water){
			planarPecentageWater = water;
		},
		getPlanarPercentWater(){
			return planarPecentageWater;
		},
		setRenameName(renameName){
			planarRename = renameName;
		},
		getRenameName(){
			return planarRename;
		},
		buildGradients: function(){
			var nextIncrementStart = parseFloat(0.0).toFixed(3);
			for (var idex = 0; idex < planarColorsArray.length; idex++){
				var o_colorPercentageSet = planarColorsArray[idex];
				var o_gradientBuilder = new gradientBuilder();
				var s_percentage = o_colorPercentageSet.getColorPercentage();
				var r_percentage = parseFloat(s_percentage).toFixed(3);
				var s_color = o_colorPercentageSet.getPlanarColor();
				o_gradientBuilder.setColor(s_color);
				nextIncrementStart = Number(nextIncrementStart) + Number(r_percentage);
				if(nextIncrementStart > 1.0){
					nextIncrementStart = Number(1.0);	// 100% coming up 100.1%
				}
				o_gradientBuilder.setGradientPercentage(nextIncrementStart);
				gradientsArray.push(o_gradientBuilder);
			}
			
		},
		fetchGradients: function(){
 			return gradientsArray;
		}	
	}
	
});

/**
 * keep x, y coordinates of a system/cluster
 * not "static" has to be instantiated
 */
var clusterViewCoordinates  = (function(){
	// private
	
	var topLeftX;	// refactor, should be using the point object
	var topLeftY;
	var bottomLeftX;
	var bottomLeftY;
	var topRightX;
	var topRightY;
	var bottomRightX;
	var bottomRightY;
//	var middleX;
//	var middleY;
	var middlePoint;
	
	// public
	return {
		setAttributesFromRectangle: function(runningX, runningY, widthBoxX, widthBoxY){
			topLeftX = runningX;
			topLeftY = runningY;
			bottomLeftX = runningX;
			bottomLeftY = runningY + widthBoxY;
			topRightX = runningX + widthBoxX;
			topRightY = runningY;
			bottomRightX = runningX + widthBoxX;
			bottomRightY = runningY + widthBoxY;
			var middleX = (topLeftX + bottomRightX)/2;  // always a integer
			var middleY = (topLeftY + bottomRightY)/2;
			middlePoint = new point();
			middlePoint.setXandY(middleX, middleY);
		},	// start deprecated
		getTopLeftX: function(){
			return topLeftX;
		},
		getTopLeftY: function(){
			return topLeftY;
		},
		getBottomLeftX: function(){
			return bottomLeftX;
		},
		getBottomLeftY: function(){
			return bottomLeftY;
		},
		getTopRightX: function(){
			return topRightX;
		},
		getTopRightY: function(){
			return topRightY;
		},
		getBottomRightX: function(){
			return bottomRightX;
		},
		getBottomRightY: function(){
			return bottomRightY;
		},	// end deprecated
		getMiddlePoint(){
			return middlePoint;
		}
	}
	
});

/**
 * canvas holding area
 */
var canvasas = (function(){
	
	const xtra = 150;
	
	var starsystemscanvas;
	var starsinclustertextcanvas;
	var starsystemscanvasContext;
	var starsinclustertextcanvasContext;

	var newStarAndPlanetsCanvas;
	var newStarAndPlanetsContext;
	
	var newStarsystemscanvasContext;
	var newStarsystemscanvas;
	
	function buildStarSystemCanvas(){
		starsystemscanvas = document.getElementById("starsystems");
		starsystemscanvasContext = starsystemscanvas.getContext("2d");
		starsystemscanvasContext.canvas.width = window.innerWidth/2;
		starsystemscanvasContext.canvas.height = window.innerHeight*3;
		starsystemscanvasContext.fillStyle = "#00003D";
		
	}
	
	function buildCanvasas(){
		buildStarSystemCanvas();
		
		newStarsystemscanvas = document.getElementById("starsystems");
		newStarsystemscanvasContext = starsystemscanvas.getContext("2d");
		newStarsystemscanvasContext.canvas.width = window.innerWidth/2;
		newStarsystemscanvasContext.canvas.height = window.innerHeight*3;


		
		starsinclustertextcanvas = document.getElementById("starsinclustertextcanvas");
		starsinclustertextcanvasContext = starsinclustertextcanvas.getContext("2d");
		var wi = window.innerWidth/3+xtra;
		var hi = window.innerHeight*3;
		console.log("HEIGHT AND WIDTH:"+wi+"::"+hi+"::");
		starsinclustertextcanvasContext.canvas.width = wi;
		starsinclustertextcanvasContext.canvas.height = hi ;
		starsinclustertextcanvasContext.canvas.style.position = 'left';
		
		newStarAndPlanetsCanvas = document.getElementById("starsinclustertextcanvas");
		newStarAndPlanetsContext = starsinclustertextcanvas.getContext("2d");
		var wi = window.innerWidth/3+xtra;
		var hi = window.innerHeight*3;
		console.log("HEIGHT AND WIDTH:"+wi+"::"+hi+"::");
		newStarAndPlanetsContext.canvas.width = wi;
		newStarAndPlanetsContext.canvas.height = hi ;

	}
	
	return{
		init: function(){
			buildCanvasas();
		},
		initStarSystem: function(){
			buildStarSystemCanvas();
		},
		fetchStarSystemsCanvas(){
			return starsystemscanvas;
		},
		fetchStarSystemsCanvasContext(){
			return starsystemscanvasContext;
		},
		fetchNewStarSystemsCanvasContext(){
			return newStarsystemscanvasContext;
		},
		fetchStarsInClusterTextCanvas(){
			return starsinclustertextcanvas;
		},
		fetchStarsInClusterTextCanvasContext(){
			starsinclustertextcanvasContext.fillStyle = "midnightblue";
			return starsinclustertextcanvasContext;
		},
		fetchStarsInClusterTextCanvasContextNoFill(){
			return starsinclustertextcanvasContext;
		},
		fetchNewStarAndPlanetsContext(){
			return newStarAndPlanetsContext;
		},
		clearStarSystemsCanvasContext(){
			starsystemscanvasContext.clearRect(0,0, starsystemscanvasContext.canvas.width, 
					starsystemscanvasContext.canvas.height);
		},
		clearStarsInClusterTextCanvasContext(){
			starsinclustertextcanvasContext.clearRect(0,0, starsinclustertextcanvasContext.canvas.width, 
					starsinclustertextcanvasContext.canvas.height);
		}
	}
})();

/**
 * star size and color object
 */
var vizStarSizes = (function(){
	
	var smallSize;
	var bigSize;
	var color;
	
	return {
		init: function(i_smallSize, i_bigSize, s_color){
			smallSize = i_smallSize;
			bigSize = i_bigSize;
			color = s_color;
		},
		fetchSmallSize: function(){
			return smallSize;
		},
		fetchBigSize: function(){
			return bigSize;
		},
		fetchColor: function(){
			return color;
		}
	}
	
});

/**
 * visualize stars by type object
 */

var vizStars = (function(){
	// private 
	
	var starColorDictionary;
	var starImageDictionary;
	var starSize;
	var imageURL;
	
	// public
	return {
		init: function(){
			starColorDictionary = new buckets.Dictionary();
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'blue');
			starColorDictionary.set('Blue Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'lightblue');
			starColorDictionary.set('Light Blue Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'white');
			starColorDictionary.set('White Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'lightyellow');
			starColorDictionary.set('Pale Yellow Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'yellow');
			starColorDictionary.set('Yellow Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'orange');
			starColorDictionary.set('Orange Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'orange');
			starColorDictionary.set('Red Super Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'blue');
			starColorDictionary.set('Blue Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'lightblue');
			starColorDictionary.set('Light Blue Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'white');
			starColorDictionary.set('White Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'lightyellow');
			starColorDictionary.set('Pale Yellow Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'yellow');
			starColorDictionary.set('Yellow Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'orange');
			starColorDictionary.set('Orange Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 14, 'orange');
			starColorDictionary.set('Red Super Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'blue');
			starColorDictionary.set('Blue Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'lightblue');
			starColorDictionary.set('Light Blue  Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'white');
			starColorDictionary.set('White Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'lightyellow');
			starColorDictionary.set('Pale Yellow Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'yellow');
			starColorDictionary.set('Yellow Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'orange');
			starColorDictionary.set('Orange Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'red');
			starColorDictionary.set('Red Giant II', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'blue');
			starColorDictionary.set('Blue Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'lightblue');
			starColorDictionary.set('Light Blue  Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'white');
			starColorDictionary.set('White Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'lightyellow');
			starColorDictionary.set('Pale Yellow Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'yellow');
			starColorDictionary.set('Yellow Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'orange');
			starColorDictionary.set('Orange Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(5, 13, 'red');
			starColorDictionary.set('Red Giant I', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'blue');
			starColorDictionary.set('Blue Sub Giant', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'lightblue');
			starColorDictionary.set('Light Blue Sub Giant', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'white');
			starColorDictionary.set('White Sub Giant', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'lightyellow');
			starColorDictionary.set('Pale Yellow SubGiant', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'yellow');
			starColorDictionary.set('Yellow Sub Giant', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'orange');
			starColorDictionary.set('Orange Sub Giant', starSize);
			starSize = new vizStarSizes();
			starSize.init(4, 10, 'red');
			starColorDictionary.set('Red Sub Giant', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'blue');
			starColorDictionary.set('Blue Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'lightblue');
			starColorDictionary.set('Light Blue Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'white');
			starColorDictionary.set('White Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'lightyellow');
			starColorDictionary.set('Pale Yellow Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'yellow');
			starColorDictionary.set('Yellow Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'orange');
			starColorDictionary.set('Orange Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(3, 8, 'red');
			starColorDictionary.set('Red Main Sequence', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'blue');
			starColorDictionary.set('Blue Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'lightblue');
			starColorDictionary.set('Light Blue Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'white');
			starColorDictionary.set('White Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'lightyellow');
			starColorDictionary.set('Pale Yellow Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'yellow');
			starColorDictionary.set('Yellow Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'orange');
			starColorDictionary.set('Orange Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 7, 'red');
			starColorDictionary.set('Red Sub Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'blue');
			starColorDictionary.set('Blue Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'lightblue');
			starColorDictionary.set('Light Blue Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'white');
			starColorDictionary.set('White Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'lightyellow');
			starColorDictionary.set('Pale Yellow Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'yellow');
			starColorDictionary.set('Yellow Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'orange');
			starColorDictionary.set('Orange Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'red');
			starColorDictionary.set('Red Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 6, 'purple');
			starColorDictionary.set('Purple Red Dwarf', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 5, 'brown');
			starColorDictionary.set('Brown Sub Star', starSize);
			starSize = new vizStarSizes();
			starSize.init(2, 5, 'chocolate');
			starColorDictionary.set('Dark Brown Sub Dwarf', starSize);
			
		
			starImageDictionary = new buckets.Dictionary();
			starImageDictionary.set('Blue Super Giant II', 'BlueSuperGiantII.png');
			starImageDictionary.set('Light Blue Super Giant II', 'LightBlueSuperGiantII.png');
			starImageDictionary.set('White Super Giant II', 'WhiteSuperGiantII.png');
			starImageDictionary.set('Pale Yellow Super Giant II', 'PaleYellowSuperGiantII.png');
			starImageDictionary.set('Yellow Super Giant II', 'YellowSuperGiantII.png');
			starImageDictionary.set('Orange Super Giant II', 'OrangeSuperGiantII.png');
			starImageDictionary.set('Red Super Giant II', 'RedSuperGiantII,png');
			starImageDictionary.set('Blue Super Giant I', 'BlueSuperGiantI.png');
			starImageDictionary.set('Light Blue Super Giant I', 'LightBlueSuperGiantI.png');
			starImageDictionary.set('White Super Giant I', 'WhiteSuperGiantI.png');
			starImageDictionary.set('Pale Yellow Super Giant I', 'PaleYellowSuperGiantI.png');
			starImageDictionary.set('Yellow Super Giant I', 'YellowSuperGiantI.png');
			starImageDictionary.set('Orange Super Giant I', 'OrangeSuperGiantI.png');
			starImageDictionary.set('Red Super Giant I', 'RedSuperGiantI.png');
			starImageDictionary.set('Blue Giant II', 'BlueGiantII.png');
			starImageDictionary.set('Light Blue  Giant II', 'LightBlueGiantII.png');
			starImageDictionary.set('White Giant II', 'WhiteGiantII.png');
			starImageDictionary.set('Pale Yellow Giant II', 'PaleYellowGiantII.png');
			starImageDictionary.set('Yellow Giant II', 'YellowGiantII.png');
			starImageDictionary.set('Orange Giant II', 'OrangeGiantII.png');
			starImageDictionary.set('Red Giant II', 'RedGiantII,png');
			starImageDictionary.set('Blue Giant I', 'BlueGiantI.png');
			starImageDictionary.set('Light Blue  Giant I', 'LightBlueGiantI.png');
			starImageDictionary.set('White Giant I', 'WhiteGiantI.png');
			starImageDictionary.set('Pale Yellow Giant I', 'PaleYellowGiantI.png');
			starImageDictionary.set('Yellow Giant I', 'YellowGiantI.png');
			starImageDictionary.set('Orange Giant I', 'OrangeGiantI.png');
			starImageDictionary.set('Red Giant I', 'RedGiantI.png');
			starImageDictionary.set('Blue Sub Giant', 'BlueSubGiant.png');
			starImageDictionary.set('Light Blue Sub Giant', 'LightBlueSubGiant.png');
			starImageDictionary.set('White Sub Giant', 'WhiteSubGiant.png');
			starImageDictionary.set('Pale Yellow SubGiant', 'PaleYellowSubGiant.png');
			starImageDictionary.set('Yellow Sub Giant', 'YellowSubGiant.png');
			starImageDictionary.set('Orange Sub Giant', 'OrangeSubGiant.png');
			starImageDictionary.set('Red Sub Giant', 'RedSubGiant.png');
			starImageDictionary.set('Blue Main Sequence', 'BlueMainSequence.png');
			starImageDictionary.set('Light Blue Main Sequence', 'LightBlueMainSequence.png');
			starImageDictionary.set('White Main Sequence', 'WhiteMainSequence.png');
			starImageDictionary.set('Pale Yellow Main Sequence', 'PaleYellowMainSequence.png');
			starImageDictionary.set('Yellow Main Sequence', 'YellowMainSequence.png');
			starImageDictionary.set('Orange Main Sequence', 'OrangeMainSequence.png');
			starImageDictionary.set('Red Main Sequence', 'RedMainSequence.png');
			starImageDictionary.set('Blue Sub Dwarf', 'BlueSubDwarf.png');
			starImageDictionary.set('Light Blue Sub Dwarf', 'LightBlueSubDwarf.png');
			starImageDictionary.set('White Sub Dwarf', 'WhiteSubDwarf.png');
			starImageDictionary.set('Pale Yellow Sub Dwarf', 'PaleYellowSubDwarf.png');
			starImageDictionary.set('Yellow Sub Dwarf', 'YellowSubDwarf.png');
			starImageDictionary.set('Orange Sub Dwarf', 'OrangeSubDwarf.png');
			starImageDictionary.set('Red Sub Dwarf', 'RedSubDwarf.png');
			starImageDictionary.set('Blue Dwarf', 'BlueDwarf.png');
			starImageDictionary.set('Light Blue Dwarf', 'LightBlueDwarf.png');
			starImageDictionary.set('White Dwarf', 'WhiteDwarf.png');
			starImageDictionary.set('Pale Yellow Dwarf', 'PaleYellowDwarf.png');
			starImageDictionary.set('Yellow Dwarf', 'YellowDwarf.png');
			starImageDictionary.set('Orange Dwarf', 'OrangeDwarf.png');
			starImageDictionary.set('Red Dwarf', 'RedDwarf.png');
			starImageDictionary.set('Purple Red Dwarf', 'PurpleRedDwarf.png');
			starImageDictionary.set('Brown Sub Star', 'BrownSubStar.png');
			starImageDictionary.set('Dark Brown Sub Dwarf', 'DarkBrownSubDwarf.png');
		},
		fetchStarSizeAndColor: function(color){
			return starColorDictionary.get(color);
		},
		setImageURL(url){
			imageURL = url;
		},
		getImageURL(){
			return imageURL;
		},
		getImage(starColor){
			return starImageDictionary.get(starColor);
		}
		
	}
	
})();

/**
 * map of the planars radius to the size of image
 * displayed on the page.
 */
var vizPlanars = (function(){
	
	var radiusDictionary;
	
	var o_radiusMap;
	return{
		init: function(){
			radiusDictionary = new buckets.Dictionary();
			radiusDictionary.set(0, 10); // smallest rendering
			radiusDictionary.set(400, 11);
			radiusDictionary.set(800, 12);
			radiusDictionary.set(1200, 13);
			radiusDictionary.set(2500, 14);
			radiusDictionary.set(6000, 15);
			radiusDictionary.set(8000, 16);
			radiusDictionary.set(10000, 17);
			radiusDictionary.set(12000, 18);
			radiusDictionary.set(14000, 19);
			radiusDictionary.set(18000, 20);
			radiusDictionary.set(24000, 21);
			radiusDictionary.set(30000, 22);
			radiusDictionary.set(38000, 23);
			radiusDictionary.set(42000, 24);
			radiusDictionary.set(60000, 23);
			radiusDictionary.set(90000, 26);
			radiusDictionary.set(200000, 27);
			radiusDictionary.set(600000, 28); // largest rendering
			radiusDictionary.set(Math.floor(Number.MAX_VALUE), 0);
		},
		fetchImageSize: function(radius){
			var sizeIncrements = radiusDictionary.keys();
			var imageSize;  // must have a value when returned
			for(var idex = 0; idex < sizeIncrements.length; idex++){
				if(radius >= sizeIncrements[idex] && radius < sizeIncrements[idex+1]){
					imageSize = radiusDictionary.get(sizeIncrements[idex]);
					break
				}
			}
			return imageSize;
		}
	}
	
})();

/**
 * moon visualization object
 */
var moonViz = (function(){
	const delta100 = 100.0;
	const delta90 = 90.0;
	const delta75 = 75.0;
	const delta50 = 50.0;
	const delta30 = 30.0;
	const delta15 = 15.0;
	
	const eMinus7ToeMinus5start = 5.0;
	const eMinus5ToeMinus4start = 20.0;
	const eMinus4ToeMinus1start = 50.0;
	const eMinus1ToE1start = 75.0;
	const e1ToE4start = 150.0;
	const e4ToE5start = 200.0;
	const e5ToE10start = 300.0;
	const e10ToE30start = 400.0;
	const e30ToE50start = 490.0;
	
	const eMinus7 = 0.0000001;
	const eMinus5 = 0.00001;
	const eMinus4 = 0.0001;
	const eMinus1 = 0.1;
	const e1 = 1.0;
	const e4 = 1000.0;
	const e5 = 10000.0;
	const e10 = 1000000000.0;
	const e30 = 1000000000000000000000000000000.0;
	const e50 = 100000000000000000000000000000000000000000000000000.0;
	
	const compute = function(startPos, distance, eSub2, eSub1, interval){
		var answer = startPos + distance/((eSub2-eSub1)/interval);
		return answer;
	}
	
	const eMinusSevenToeMinusFive = function(distance){
		return Math.floor(compute(eMinus7ToeMinus5start, distance, eMinus7, eMinus5, delta15));
	}
	const eMinusFiveToeMinusFour = function(distance){
		return Math.floor(compute(eMinus5ToeMinus4start, distance, eMinus5, eMinus4, delta30));
	}
	const eMinusFourToeMinusOne = function(distance){
		return Math.floor(compute(eMinus4ToeMinus1start, distance, eMinus4, eMinus1, delta15));
	}
	const eMinusOneToEOne = function(distance){
		return Math.floor(compute(eMinus1ToE1start, distance, eMinus1, e1, delta75));
	}
	const eOneToEfour = function(distance){
		return Math.floor(compute(e1ToE4start, distance, e1, e4, delta30));
	}
	const eFourToEfive = function(distance){
		return Math.floor(compute(e4ToE5start, distance, e4, e5, delta100));
	}
	const eFiveToEten = function(distance){
		return Math.floor(compute(e5ToE10start, distance, e5, e10, delta100));
	}
	const eTenToEthirty = function(distance){
		return Math.floor(compute(e10ToE30start, distance, e10, e30, delta90));
	}
	const eThirtyToEfifty = function(distance){
		return Math.floor(compute(e30ToE50start, distance, e30, e50, delta30));
	}
	
	
	var orbitRadiusDistArray;
	var o_descriminator;
	var o_runningDesc;
	var action;
	
	
	function initPrivate(){
		orbitRadiusDistArray = [];
		o_descriminator = new descriminator();
		o_descriminator.setBounds(eMinus7, eMinus5, eMinusSevenToeMinusFive);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(eMinus5, eMinus4, eMinusFiveToeMinusFour);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(eMinus4, eMinus1, eMinusFourToeMinusOne);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(eMinus1, e1, eMinusOneToEOne);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(e1, e4, eOneToEfour);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(e4, e5, eFourToEfive);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(e5, e10, eFiveToEten);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(e10, e30, eTenToEthirty);
		orbitRadiusDistArray.push(o_descriminator);
		o_descriminator = new descriminator();
		o_descriminator.setBounds(e30, e50, eThirtyToEfifty);
		orbitRadiusDistArray.push(o_descriminator);
	}
	return{
		init: function(){
			initPrivate();
		},
		computeMoonVizRadius: function(distance){
			var o_distance = new Number(distance);
			for (var idex = 0; idex < orbitRadiusDistArray.length; idex++){
				o_runningDesc = orbitRadiusDistArray[idex];
				var larger = o_runningDesc.getSecondBound();
				var smaller = o_runningDesc.getFirstBound();
				if(o_distance >= smaller && o_distance < larger){
					action = o_runningDesc.getMethod();
					break;
				}
			}
			return action(o_distance);
		}
	}
	
})();

/*
 * basic object for visualizing cluster inside a system, 
 *  that is a stars color, which can determine its graphical 
 *  size and a scalar in x and y where to visualize the star in
 *  cluster.
 */
var starVizElements = (function(){
	var a_relativeSystemVector;
	var starColor;
	
	return{
		setScalarXandYandColor: function(sX, sY, s_starColor){
			a_relativeSystemVector = new relativeSystemVector();
			a_relativeSystemVector.setScalarXandY(sX, sY);
			starColor = s_starColor;
		},
		fetchRelativeSystemVector: function(){
			return a_relativeSystemVector;
		},
		fetchStarColor: function(){
			return starColor;
		}
	}
});

/**
 * visualize a planars orbit as an elipse
 */
var ellipseWithPlanar = (function(){
	var yScale = 2;
	/*
	* a proper graphics program would use a matrix transformation
	*/
	function warpY(degree){
		if(degree < 90){
			return degree + 270;
		}
		else{
			if(degree == 90){
				return 0;
			}
			else{
				return degree - 90;
			}
		}
	}
	
	return {
		drawEllipseAndPlanar: function(o_point, radius, degree, color, context){
			var scale = scaleViz.fetchScale();
			var s_radius = scale*radius;
			var degreePrime = warpY(degree) * Math.PI / 180;	
			var centreX = o_point.getX();
			var centreY = o_point.getY();
			var xAxis = s_radius / 2;
			var yAxis = s_radius;
			var previousI;
			
			context.beginPath();
			for (var idex = 0 * Math.PI; idex < 2 * Math.PI; idex += 0.01 ) {
			    var xPos = centreX - (xAxis * Math.sin(idex)) * Math.sin(0 * Math.PI) + (yAxis * Math.cos(idex)) * Math.cos(0 * Math.PI);
			    var yPos = centreY + (yAxis * Math.cos(idex)) * Math.sin(0 * Math.PI) + (xAxis * Math.sin(idex)) * Math.cos(0 * Math.PI);

			    if (idex == 0) {
			        context.moveTo(xPos, yPos);
			    } else {
			        context.lineTo(xPos, yPos);
			        if(degreePrime > previousI && degreePrime <= idex){
			        	context.arc(xPos, yPos, 2, 0, 2*Math.PI, false);
			        }
			        else{
			        	if (degreePrime == 0 && previousI == 0){
			        		context.arc(xPos, yPos, 2, 0, 2*Math.PI, false);
			        	}
			        }
			    }
			    previousI = idex;
			    
			    // console.log("xPos:"+xPos+" yPos: "+ yPos + " Index: " + idex);
			}
			context.lineWidth = 1;
			var o_vizStarSizes = vizStars.fetchStarSizeAndColor(color);
			var starColor = o_vizStarSizes.fetchColor();
			if(starColor == "blue"){
				starColor = "#3BB9FF";  // blue too dark to see.
			}
			context.strokeStyle = starColor;
			context.stroke();
			context.closePath();

		}
	}

})();

/**
 * scales visualization of the planars and the orbits
 */
var scaleViz = (function(){
	
	const xBoxLarger = 50;
	const yBox = 50;
	const spacing = 5;
	const yHeight = 20;
	const scaleDigits = 32;
	
	
	const bigger = "Increase Scale  ";
	const smaller = "Decrease Scale  ";
	const value = "Current Scale:";
	const reset = "Reset Scale  ";
	const toggle = "Toggle Entity Graphic";
	
	const step = 0.1;
	
	const PLANETS = "PLANETS";
	const MOONS = "MOONS";
	
	var scale = 1.0;
	var biggerWidth;
	var smallerWidth;
	var valueWidth;
	var resetWidth;
	var toggleWidth;
	
	var xBoxSmaller;
	var xBoxCurrent;
	var xBoxReset;
	var xBoxToggle;
	
	var scale=1.0;
	var mode;
	
	var entityDisplay=0;
	
	function finish(){
		canvasas.clearStarSystemsCanvasContext();
		canvasas.initStarSystem();
		if(mode == PLANETS){
			scalePlanets();
		}
		else{
			if(mode == MOONS){
				scaleMoons();
			}
			else{
				throw "Bad Mode Value:"+mode;
			}
		}

	}
	
	function scalePlanets(){
		processStarAndPlanetsDetail.f_drawStarInCentre();
		processStarAndPlanetsDetail.f_drawPlanetoidsAroundStar();
	}
	
	function scaleMoons(){
		processPlanetAndMoonsDetail.f_drawPlanetInCentre();
		processPlanetAndMoonsDetail.f_drawMoons();
	}
	
	return{
		drawControls: function(context){
			context.font="16px Verdana";
			biggerWidth = Math.floor(context.measureText(bigger).width);
			smallerWidth = Math.floor(context.measureText(smaller).width);
			valueWidth = Math.floor(context.measureText(value).width+30);
			resetWidth = Math.floor(context.measureText(reset).width);
			toggleWidth = Math.floor(context.measureText(toggle).width);
			
			xBoxSmaller = xBoxLarger+biggerWidth+spacing;
			xBoxCurrent = xBoxLarger+biggerWidth+spacing+smallerWidth+spacing+spacing;
			xBoxReset = xBoxLarger+biggerWidth+spacing+smallerWidth+spacing+valueWidth+spacing;
			xBoxToggle = xBoxLarger+biggerWidth+spacing+smallerWidth+spacing+valueWidth+spacing+resetWidth+spacing;

			context.beginPath();
		    context.rect(xBoxLarger, yBox, biggerWidth, yHeight);
		    context.fillStyle = 'lightgreen';xBoxCurrent;
		    context.fill();
		    context.lineWidth = 2;
		    context.strokeStyle = 'black';
		    context.strokeText(bigger, xBoxLarger, yBox+yHeight-3);
		    context.stroke();
		    context.closePath();
		    
			context.beginPath();
		    context.rect(xBoxSmaller, yBox, smallerWidth, yHeight);
		    context.fillStyle = 'red';
		    context.fill();
		    context.lineWidth = 2;
		    context.strokeStyle = 'black';
		    context.strokeText(smaller, xBoxSmaller, yBox+yHeight-3);
		    context.stroke();
		    context.closePath();
		    
		    context.beginPath();
		    context.rect(xBoxCurrent, yBox, valueWidth+scaleDigits, yHeight);
		    context.fillStyle = 'yellow';
		    context.fill();
		    context.lineWidth = 2;
		    context.strokeStyle = 'black';
		    context.strokeText(value+scale, xBoxCurrent, yBox+yHeight-3);
		    context.stroke();
		    context.closePath();

		    context.beginPath();
		    context.rect(xBoxReset, yBox, resetWidth, yHeight);
		    context.fillStyle = 'orange';
		    context.fill();
		    context.lineWidth = 2;
		    context.strokeStyle = 'black';
		    context.strokeText(reset, xBoxReset, yBox+yHeight-3);
		    context.stroke();
		    context.closePath();

		    context.beginPath();
		    context.rect(xBoxToggle, yBox, toggleWidth, yHeight);
		    context.fillStyle = 'lightblue';
		    context.fill();
		    context.lineWidth = 2;
		    context.strokeStyle = 'black';
		    context.strokeText(toggle, xBoxToggle, yBox+yHeight-3);
		    context.stroke();
		    context.closePath();
		},
		fetchScale: function(){
			return scale;
		},
		fetchEntityDislay: function(){
			return entityDisplay;
		},
		resetScale: function(){
			scale=1.0;
		},
		determineClick: function(clickedX, clickedY){
			if(clickedX >= xBoxLarger && clickedX <= xBoxLarger+biggerWidth
					&& clickedY >= yBox && clickedY <= yBox+yHeight){
				scale += step;
				scale = Math.floor(scale*100)/100
				finish();
			}
			if(clickedX >= xBoxSmaller && clickedX <= xBoxSmaller+smallerWidth
					&& clickedY >= yBox && clickedY <= yBox+yHeight){
				scale -= step;
				scale = Math.floor(scale*100)/100
				finish();
			}
			if(clickedX >= xBoxCurrent && clickedX <= xBoxCurrent+valueWidth
					&& clickedY >= yBox && clickedY <= yBox+yHeight){
				// doesn't do anything
				console.log("Clicking on the current scale does nothing")
			}
			if(clickedX >= xBoxReset && clickedX <= xBoxReset+resetWidth
					&& clickedY >= yBox && clickedY <= yBox+yHeight){
				scale = 1.0;
				scale = Math.floor(scale*100)/100
				finish();
			}
			if(clickedX >= xBoxToggle && clickedX <= xBoxToggle+toggleWidth
					&& clickedY >= yBox && clickedY <= yBox+yHeight){
				
				console.log("Toggling display entity or display system");
				if(entityDisplay === 0){
					entityDisplay = 1;
					processStarAndPlanetsDetail.f_drawStarImage();
				}
				else{
					canvasas.initStarSystem();
					entityDisplay = 0;
					processStarAndPlanetsDetail.f_drawStarInCentre();
					processStarAndPlanetsDetail.f_drawPlanetoidsAroundStar();
				}
			}

		},
		setModePlanets: function(){
			mode = PLANETS;
		},
		setModeMoons: function(){
			mode = MOONS;
		},
		fetchEntityDisplay(){
			return entityDisplay;
		}
	}
	
})();

/**
 * must be reinitliazed for each jump into a star system
 *
 * cvCoordinates has already been instantiated and initialized.
 */
var clusterViewCoordinatesToSystemName = (function (){
	// private
	var systemNameCoordinatesDictionary;
	
	return {
		initArrays: function(){	// sic ... dictionaries
			systemNameCoordinatesDictionary = new buckets.Dictionary(); 
		},
		process: function(systemName, cvCoordinates){
			systemNameCoordinatesDictionary.set(systemName, cvCoordinates);
		},
		fetchCVCoordinates(systemName){
			return systemNameCoordinatesDictionary.get(systemName);
		},
		fetchSystemNames(){
			return systemNameCoordinatesDictionary.keys();
		}
	}
	
})();


/*
 * simple map to hold renamed systems
 */
var renameMap = (function () {
	var theRenameMap;
	
	return{
		init: function(){
			theRenameMap = new buckets.Dictionary();
		},
		get: function(systemName){
			var result = theRenameMap.get(systemName);
			console.log("Rename for system:"+result+" System:"+systemName);
			return result;
		},
		set: function(systemName, reName){
			/*
       	    if(reName === "" || reName === ","){
    	  	 reName = " ";
    	    }
    	    */

			theRenameMap.set(systemName, reName);
			console.log("Set Rename for system:"+reName+" System:"+systemName);
		}
	}
})();

/**
 * build cluster values for visualizatrion after system matrix visualized.
 */
var clusterValues = (function () {
	// private
	var clusterVizCentricArray;
	var systemDictionary = new buckets.Dictionary();
	var starDictionary;
	var rawDictionary;
	
	var currentSystem;
	var workingClusterVizCentric;
	var currentStarKey;
	
	var starName;
	
	var done;
	
	var setOperations = [
	                     function setInstance(systemName){
	                    	 starDictionary = new buckets.Dictionary();
	                    	 systemDictionary.set(systemName, starDictionary);
	                    	 // console.log("SYSTEM DICTIONARY init for:" + systemName + "starDictionary:" + systemDictionary.get(systemName));
	                     },
	                     function setSubClusterDescription(description){
	                    	 // the first star attribute
	                    	 workingClusterVizCentric.setSubClusterDescription(description.toString());
	                    	 console.log("SUBCLUSTER_DESCRIPTION:"+description.toString());
	                     },
	                     function setAnglenInRadians(angle){
	                    	 workingClusterVizCentric.setAnglenInRadians(angle);
	                     	 console.log("ANGLE_IN_RADIANS:"+angle.toString());
	                  	                     },
	                     function setDistanceClusterVirtCentre(distance){
	                  	     workingClusterVizCentric.setDistanceClusterVirtCentre(distance);
	                    	 console.log("DISTANCE CENTRE:"+distance.toString());
	                     },
	                     function setLuminosity(lumens){
	                    	 workingClusterVizCentric.setLuminosity(lumens);
	                    	 console.log("LUMENS:"+lumens.toString());
	                     },
	                     function setStarName(name){
	                    	 workingClusterVizCentric.setStarName(name);
	                    	 currentStarKey = name;
	                    	 console.log("STAR_NAME:"+name.toString());
	                    	 starName=name.toString();
	                     },
	                     function setStarColor(color){
	                    	 workingClusterVizCentric.setStarColor(color);
	                    	 console.log("STAR_COLOR:"+color.toString());
	                     },
	                     function setStarSize(size){
	                    	 workingClusterVizCentric.setStarSize(size);
	                    	 console.log("STAR_SIZE:"+size.toString());
	                     },
	                     function setRename(s_rename){
	                    	 workingClusterVizCentric.setRename(s_rename);
	                    	 if(s_rename === "" || s_rename === ","){
	                    		 s_rename = " ";
	                    	 }
	                    	 renameMap.set(currentStarKey, s_rename);
	                    	 console.log("STAR_RENAME:"+s_rename);	                    	 
	                     },
                         function setStarType(type){
	                    	 workingClusterVizCentric.setStarType(type);  // last star attribute, save cluster viz centric
	                    	 var starDict = systemDictionary.get(currentSystem);
	                    	 starDict.set(currentStarKey, workingClusterVizCentric);
	                    	 console.log("STAR_TYPE:"+type.toString()+" ADDING:"+currentStarKey+":: "+workingClusterVizCentric.getStarName());
	                    	 console.log("CURRENT SYSTEM" + currentSystem + " ::" + starDict.keys());
	                    	 workingClusterVizCentric = new clusterVizCentric();
	                     },
	                    ];
	
						var references = {
								"instance" : 0,
								"sub_cluster_description" : 1,
								"angle_in_radians_s" : 2,
								"distance_clust_virt_centre" : 3,
								"luminosity" : 4,
								"Name" : 5,
								"star_color" : 6,
								"star_size" : 7,
								"renameName" : 8,
								"star_type" : 9,

						}
	return{
		initArrays: function(systemName){
			setOperations[references["instance"]](systemName);
			clusterVizCentricArray = [];
			workingClusterVizCentric = new clusterVizCentric();
		},
		init2Arrays: function(systemName){
			clusterVizCentricArray = [];
			workingClusterVizCentric = new clusterVizCentric();
		},
		addToclusterVizCentricArray: function(keyValuePairArray){
			console.log("KEY VALUE PAIR ARRAY:"+keyValuePairArray[0].getKey()+":: "+ keyValuePairArray[0].getValue());
			clusterVizCentricArray.push(keyValuePairArray);
		},
		storeVizCentricArray: function(systemName){
			rawDictionary.set(systemName, clusterVizCentricArray);
			console.log("SAVING clusterVizCentricArray for SYSTEM:"+systemName);
			clusterVizCentricArray = [];
		},
		getClusterVizCentricArraySize(){
			return clusterVizCentricArray.length;
		},
		getSystemNameArraySize(){
			return rawDictionary.size();
		},
		getSystemNameKeys(){
			return rawDictionary.keys();
		},
		builder(){
			
			var systemNameArray =  rawDictionary.keys();
			for(var idex = 0; idex <  systemNameArray.length; idex++){
				currentSystem = systemNameArray[idex];
				console.log(" BUILD SYSTEM:" + currentSystem);
				var rawClusterArray = rawDictionary.get(currentSystem);

				for(var idex2 = 0; idex2 < rawClusterArray.length; idex2++){  
					var pairs = rawClusterArray[idex2];
					for(var idex3 = 0; idex3 < pairs.length; idex3++){
						setOperations[references[pairs[idex3].getKey()]](pairs[idex3].getValue());
					}
				}
			}
			console.log("ALL SYSTEMS BUILT");
			// clusterValues.debug();name.toString()
			// oneSystem.store();
		},
		fetchProcessedCluster(){
			return systemDictionary;
		},
		reset(){
			systemDictionary = new buckets.Dictionary();
			rawDictionary = new buckets.Dictionary();
		},
		clearDone(){
			done = false;
		},
		setDone(){
			done = true;
		},
		getDone(){
			return done;
		},
		debug(){
			var dictionary = clusterValues.fetchProcessedCluster();
			var systemsWithClusters = dictionary.keys();
			for(var idex = 0; idex < systemsWithClusters.length; idex++){
				var clusterVizCentrics = dictionary.get(systemsWithClusters[idex]);
				console.log("SYSTEM WITH CLUSTER:"+systemsWithClusters[idex]);
				var system = systemsWithClusters[idex];
				var starDict = dictionary.get(system);
				var stars = starDict.keys();
			}
		},
		getStarName(){
			return starName;
		}
	}
	
})();

var oneSystem = (function () {
	
	// private
	
	var dictionary;
	var systemsWithClusters;
	var starDict;
	
	// public
	
	return{
		store(){
			dictionary = clusterValues.fetchProcessedCluster();
			system = dictionary.keys();
			console.log("ONE SYSTEM WITH CLUSTER:"+system);
			starDict = dictionary.get(system);
			var stars = starDict.keys();
			console.log("ONE SYSTEM STARs:"+stars);
		},
		fetch(){
			return dictionary;
		}
	}
	
	
})();

/**
 * Uses system name and array of stars
 */
var processClusterDetail = (function () {
	
	// private
	
	
	// public
	return{
		jsonProcess: function(json, systemName){
			clusterValues.initArrays(systemName);
			for (var idex = 0; idex < json.stars.stars.length; idex++){
				if(json.stars.stars[idex].string != undefined){
					console.log(systemName + " STARS IN CLUSTER:"+systemName+ ":: "+ json.stars.stars[idex].string);
					var orderedPairArray = orderedPairToArray.getOrderedPair(json.stars.stars[idex].string);
					// console.log("ORDERED PAIR ARRAY:"+orderedPairArray);
					clusterValues.addToclusterVizCentricArray(orderedPairArray);
					clusterValues.storeVizCentricArray(systemName);
				}
			}
			clusterValues.setDone();
		}
	}
	
})();

/**
 * Named Entity Object, instantiate with new
 */
 var namedEntity = (function(){
	 
	 // private
	 // uDimension":77116,"vDimension":75958,"renameObjectType":"CLUSTER",
	 // "genericName":"Cluster.SINGLESTAR.77116.75958","renameName":"FelgerCarb"
	 	var uDimension;
	 	var vDimension;
	 	var renameObjectType;
	 	var genericName;
	 	var fullGenericName;
	 	var renamesArray = [];
	 	var renames_count = 0;
	 	var distanceToGalacticCentre;
	 	
	 // public
	 	
	 	return {
	 	
	 		setUDimension: function (_uDimension){
		 		uDimension = _uDimension;
		 	},
		 	
		 	getUDimension: function (){
		 		return uDimension;
		 	},
		 	
		 	setVDimension: function (_vDimension){
		 		vDimension = _vDimension;
		 	},
		 	
		 	getVDimension: function (){
		 		return vDimension;
		 	},
		 	
		 	setRenameObjectType: function (_renameObjectType){
		 		renameObjectType = _renameObjectType;
		 	},
		 	
		 	getRenameObjectType: function (){
		 		return renameObjectType;
		 	},
	
		 	setGenericName: function (_genericName){
		 		genericName = _genericName;
		 	},
		 	setFullGenericName: function (_genericName){
		 		fullGenericName = _genericName;
		 	},
		 	
		 	getGenericName: function (){
		 		return genericName;
		 	},
		 	
		 	getFullGenericName: function (){
		 		return fullGenericName;
		 	},
		 	
		 	addRename: function (_renameName){
				renamesArray[renames_count] = _renameName;
				++renames_count;
		 	},
		 	
		 	getRenamesArray: function (){
		 		return renamesArray;
		 	},
		 	
		 	setDistanceToGalacticCentre: function (_distanceToGalacticCentre){
		 		distanceToGalacticCentre = _distanceToGalacticCentre;
		 	},
		 	
		 	getDistanceToGalacticCentre: function (){
		 		return distanceToGalacticCentre;
		 	}
	 	}
 });
 

var isItARenamedEntity  = (function (){
	
	return {
		jsonCall: function(type, genericName){
			console.log("in isItARenamedEntity:"+ type + "::" + genericName);
			$.getJSON("http://www.localhost:8080/johntredden-1.0/isEntityRenamed.html?type="
					+type+"&genericName="+genericName,
					function(json){           // callback
						setInterval(function () {if(json != null){clearInterval();}}, 1000);
						console.log("in isItARenamedEntity:"+json);
						parseRenames.parseStart(json);
					}
				);
			}
		}
	
})();

var parseRenames = (function(){
	
	// private
	var lineCount = 0;
	var workingRenameLine;
	var state;
	var output;

	
	// public
	
	return{
		
		parseStart: function(stream){
			lineArray = [];
			lineCount = 0;
			output = '';
			entry.init();
			
			console.log("START DEBUG");
			print_recursive(stream);  // debug
			console.log("END DEBUG");

			return parseRenames.parse(stream);
		},
		parse: function(stream){
		    if($.isArray(stream) || typeof(stream) == 'object') {
		        for(var idex in stream) {
		        	console.log("Next idex:" + idex);
		        	switch(idex){

		        	case "genericName":
		        		workingNamedEntity = new namedEntity();
		        		state = 'start';
		        		break;
		        	case "string":
		        	case "alternateNames":
		        		state = 'renameName';
		        		break;
		        	default:
		        		console.log("DEFAULT:"+idex)
		        	}
		        	parseRenames.parse(stream[idex]);
		        }
		    }else {
		    	console.log("Next stream:" + stream + " state:" + state);
		    	switch (state){
		    	
		    	case "start":
		    		workingNamedEntity.setGenericName(stream);
		    		break;
		    	case "renameName":
		    		workingNamedEntity.addRename(stream);
		    		break;
		    		
		    	default:
		    		console.log("warning:" + state);
		    	}
				var renamesArray = workingNamedEntity.getRenamesArray();
				var theRenamed = ' ';
				for(var idex1 = 0; idex1 < renamesArray.length; idex1++){
					theRenamed += renamesArray[idex1];
					theRenamed += ' ';
				}
				if(state === "renameName"){
					console.log("FINISHED PARSE:"+theRenamed);
				    // visualizeClusters.setNamedStar(theRenamed);	
				}
		    return workingNamedEntity;   
		    }
		},
	}
})();


/**
 * cluster visualization
 */
var visualizeClusters = (function (){
	
	// private
	
	var namedSystem = "  ";
	var namedStar = "  ";
	var oneAndOnlyOneClusterVizCentric;  // used only in rename a star
	var runningX;
	var runningY;
	var ctx;

	
	// public
	return{
		display : function(){
			visualizeClustersOnCanvas.resetTextDictionary();
			ctx = canvasas.fetchStarsInClusterTextCanvasContext();
			ctx.fillRect(5,20,700, window.innerHeight);
			ctx.beginPath();
			var startX = 5;
			var startY = 50;
			runningX = startX;
			runningY = startY;
			var incrementY = 20;
			var subClusterDescription;
			var starName;
			var starColor;
			var starSize;
			var starLuminosity;

			
			var dictionary = clusterValues.fetchProcessedCluster();
			var systemsWithClusters = dictionary.keys();
			ctx.font="18px Verdana";
			ctx.strokeStyle = "orange";
			ctx.strokeText("Star Systems in this Sector" + namedSystem, runningX, runningY);
			runningY += incrementY;
			runningY += incrementY;
			for(var idex = 0; idex < systemsWithClusters.length; idex++){
				var clusterVizCentrics = dictionary.get(systemsWithClusters[idex]);
				console.log("SYSTEM WITH CLUSTER:"+systemsWithClusters[idex]);
				var system = systemsWithClusters[idex];
				var starDict = dictionary.get(system);
				var stars = starDict.keys();
				var previousSystem;
				for(var idex2 = 0; idex2 < stars.length; idex2++){
					console.log("STAR WITH VIZ CENTRIC:"+stars[idex2]);
					var oneClusterVizCentric = starDict.get(stars[idex2]);	
					console.log("SubClusterDescription:"+oneClusterVizCentric.getSubClusterDescription());
					console.log("AnglenInRadians:"+oneClusterVizCentric.getAnglenInRadians());
					console.log("DistanceClusterVirtCentre:"+oneClusterVizCentric.getDistanceClusterVirtCentre());
					console.log("Luminosity:"+oneClusterVizCentric.getLuminosity());
					console.log("StarName:"+oneClusterVizCentric.getStarName());
					console.log("StarColor:"+oneClusterVizCentric.getStarColor());
					console.log("StarSize:"+oneClusterVizCentric.getStarSize());
					console.log("StarType:"+oneClusterVizCentric.getStarType());
					var starFullName = stars[idex2];
					var theRename = renameMap.get(starFullName);
					oneClusterVizCentric.setRename(theRename);
					visualizeClusters.setNamedStar(theRename);
					console.log("StarRename:"+theRename);
					
					var starPoint = visualizeClustersOnCanvas.locateScaleUsingDistance(oneClusterVizCentric.getDistanceClusterVirtCentre(), oneClusterVizCentric.getAnglenInRadians());
					var starPointXVector = starPoint.getX();
					var starPointYVector = starPoint.getY();
					visualizeClustersOnCanvas.saveSystemClusterVizScalar(starPointXVector, starPointYVector, system, oneClusterVizCentric.getStarName(), oneClusterVizCentric.getStarColor());
					console.log("STAR POINTS " + starPointXVector + " AND " + starPointYVector + " IN " + system + " SYSTEM");
					
					subClusterDescription = oneClusterVizCentric.getSubClusterDescription();
					starName = "StarName:"+oneClusterVizCentric.getStarName();
					starColor = "StarColor:"+oneClusterVizCentric.getStarColor()+ " ";
					starSize = "StarSize:"+oneClusterVizCentric.getStarSize() + " ";
					starLuminosity = "Luminosity:"+oneClusterVizCentric.getLuminosity();
					ctx.font="16px Verdana";
					ctx.strokeStyle = "yellow";
					if(previousSystem != system){
						runningY += incrementY;
						runningY += incrementY;
						ctx.strokeText("SYSTEM WITH CLUSTER:"+system, runningX, runningY);
						runningY += incrementY;
					}
					previousSystem = system;
					ctx.font="10px Verdana";
					ctx.strokeStyle = "lightblue";
					ctx.strokeText("SubClusterDescription:"+subClusterDescription, runningX, runningY);
					runningY += incrementY;
					ctx.strokeText(starName, runningX, runningY);
					
					runningY += incrementY;
					
					var o_point = new point();
					o_point.setXandY(runningX, runningY);  // saved for larger star images to select
					visualizeClustersOnCanvas.saveStarTextGeometry(oneClusterVizCentric.getStarName(), o_point);
					namedStar	
					runningY += incrementY;
					ctx.strokeText(starColor, runningX, runningY);
					var colorWidth = ctx.measureText(starColor).width;
					runningX += colorWidth ;
					ctx.strokeText(starSize, runningX, runningY);
					var luminosityWidth = ctx.measureText(starSize).width;
					runningX += luminosityWidth;
					
					visualizeClustersOnCanvas.saveMaxX(runningX);  // used to properly space larger star image.
					
					ctx.strokeText(starLuminosity, runningX, runningY);
					runningY += incrementY;
					ctx = canvasas.fetchStarsInClusterTextCanvasContext();
					
					ctx.font="20px Verdana";
					ctx.strokeStyle = "yellow";

					ctx.strokeText(namedStar, runningX+100, runningY);
					namedStar = " ";
					runningX = startX;
				}
			}
		},
		setNamedSystem: function(s_namedSystem){
			namedSystem = s_namedSystem;
		},
		setNamedStar: function(s_namedStar){
			console.log("SETTING NAMED STAR:" + s_namedStar);
			namedStar = s_namedStar;
			/*
			ctx = canvasas.fetchStarsInClusterTextCanvasContext();
			ctx.fnamedStaront="20px Verdana";
			ctx.strokeStyle = "yellow";

			ctx.strokeText(s_namedStar, 5, 500);
			*/
		},
		getNamedStar: function(){
			console.log("GETTING NAMED STAR:" + namedStar);
			return namedStar
		}
	}
	
})();

/**
 * visualize stars in cluster
 */
var visualizeStarsInClusters = ( function (){
	var previousCtx;
	var nextCtx;
	var systemNames;
	const leanLeft = 200;
	const beginY = 50;
	return{
		display: function(){
			previousCtx = canvasas.fetchStarSystemsCanvasContext();
			systemNames = visualizeClustersOnCanvas.fetchSystemNames();
			for(var idex = 0; idex < systemNames.length; idex++){
				var systemName = systemNames[idex];
				var starsDictionary = visualizeClustersOnCanvas.fetchSystemClusterVizScalar(systemName);
				var starKeys = starsDictionary.keys();  // star names are these keys
				for(var idex2 = 0; idex2 < starKeys.length; idex2++){
					var o_starVizElement = starsDictionary.get(starKeys[idex2]);
					var a_relativeSystemVector = o_starVizElement.fetchRelativeSystemVector();
					var starColor = o_starVizElement.fetchStarColor();
					var vizStarSizes = vizStars.fetchStarSizeAndColor(starColor);
					var cvCoordinates = clusterViewCoordinatesToSystemName.fetchCVCoordinates(systemName);
					var o_middlePoint = cvCoordinates.getMiddlePoint();
					
					var size = vizStarSizes.fetchSmallSize();
					var color = vizStarSizes.fetchColor();
					var startx = o_middlePoint.getX() + a_relativeSystemVector.getScalarX();
					var starty = o_middlePoint.getY() + a_relativeSystemVector.getScalarY();
					
					console.log("SYSTEM:"+systemName +" VISUALIZE STARS IN CLUSTERS X COORDINATES:"+o_middlePoint.getX()+"::"+a_relativeSystemVector.getScalarX());
					console.log("SYSTEM:"+systemName + " VISUALIZE STARS IN CLUSTERS Y COORDINATES:"+o_middlePoint.getY()+"::"+a_relativeSystemVector.getScalarY());
					
					previousCtx.beginPath();
					previousCtx.arc(startx, starty, size, 0, 2*Math.PI, false);
					previousCtx.fillStyle = color;
					previousCtx.fill();
					previousCtx.lineWidth=0;
					previousCtx.stroke();

				}
			}
			// to do: make this more object oriented.  It violates the D.R.Y. principal
			clickableAstroObjectList.init();
			clickableAstroObjectList.setStarsAndPlanets();
			var currentCanvasCtx = canvasas.fetchStarsInClusterTextCanvasContext();
			visualizeClustersOnCanvas.genStarTextGeomteryWithMaxX();
			var starTextDictionary = visualizeClustersOnCanvas.fetchStarTextDictionary();
			currentCanvasCtx.font="18px Verdana";
			currentCanvasCtx.strokeStyle = "orange";
			var firstMessageWidth = currentCanvasCtx.measureText("Star Systems in this Sector                 ").width;
			currentCanvasCtx.strokeText("Select Star By Star Image", firstMessageWidth, beginY + 20 );

			for(var idex = 0; idex < systemNames.length; idex++){
				var systemName = systemNames[idex];
				var starsDictionary = visualizeClustersOnCanvas.fetchSystemClusterVizScalar(systemName);
				var starKeys = starsDictionary.keys();
				for(var idex2 = 0; idex2 < starKeys.length; idex2++){
					var o_starVizElement = starsDictionary.get(starKeys[idex2]);
					var starColor = o_starVizElement.fetchStarColor();
					var vizStarSizes = vizStars.fetchStarSizeAndColor(starColor);
					var o_textPointOnPage = starTextDictionary.get(starKeys[idex2]);
					var size = vizStarSizes.fetchBigSize()*2;
					var color = vizStarSizes.fetchColor();
					var xDim = o_textPointOnPage.getX();
					var yDim = o_textPointOnPage.getY();
					var graphicXDim = xDim + size + leanLeft;
					currentCanvasCtx.beginPath();
					currentCanvasCtx.arc(graphicXDim, yDim, size, 0, 2*Math.PI, false);
					currentCanvasCtx.fillStyle = color;
					currentCanvasCtx.fill();
					currentCanvasCtx.lineWidth=0;
					currentCanvasCtx.stroke();
					clickableAstroObjectList.addImageGeometry(graphicXDim, yDim, size, starKeys[idex2]);
				}
			}

		}
	}
	
})();

/**
 * stars on canvas NOT in common for now
 */
var starSystemsNotUsed = (function () {
	// private
	var viz = function(systemVizCentricArray){
		var ctx = canvasas.fetchStarSystemsCanvasContext();
		ctx.fillRect(0,20,window.innerWidth/2, window.innerHeight);
		
		var lineWidth = 2;
		var flipFlop = 0;
		var startX = 50;
		var startY = 50;
		var incrementHeaderX = 20;
		var widthBoxY= 150;
		var widthBoxX = 150
		var runningX = startX;
		var runningY = startY;
		var fillStyle;
		var reset;
		console.log("LENGTH:"+systemVizCentricArray.length);
		ctx.beginPath();
		for(var idex = 0; idex < systemVizCentricArray.length; ){
			clusterValues.initArrays(systemVizCentricArray[idex].getSystemName());
			if(flipFlop == 0){
				fillStyle = 'darkblue';
			}
			else{
				fillStyle = 'midnightblue';
			}
			ctx.rect(runningX, runningY, widthBoxX, incrementHeaderX);
			ctx.fillStyle = fillStyle;
			ctx.fillRect(runningX, runningY, widthBoxX, incrementHeaderX);
			ctx.lineWidth= lineWidth;
			ctx.strokeStyle= "lightblue";
			ctx.stroke();
			
			var cvCoordinates = new clusterViewCoordinates();
			cvCoordinates.setAttributesFromRectangle(runningX, runningY, widthBoxX, widthBoxY);
			console.log("STAR SYSTEM:"+systemVizCentricArray[idex].getSystemName()+" CVCOORDINATES:"+cvCoordinates.getTopLeftX()
					+"|"+cvCoordinates.getTopLeftY()
					+"|"+cvCoordinates.getBottomRightX()
					+"|"+cvCoordinates.getBottomRightY());
			cvCoordinates.getMiddlePoint().logPrint();
				
			clusterViewCoordinatesToSystemName.process(systemVizCentricArray[idex].getSystemName(),cvCoordinates);
			
			var header = "U"+systemVizCentricArray[idex].getUCoordinate()+":V"+systemVizCentricArray[idex].getVCoordinate();
			// console.log("HEADER:"+header);
			ctx.font="16px Verdana";
			ctx.strokeText(header, runningX+2, runningY+15);
			clusterValues.clearDone();
			clusterDetailRequest.jsonCall(systemVizCentricArray[idex].getSystemName());
			
			runningY += incrementHeaderX;
			
			if(flipFlop == 0){
				fillStyle = 'midnightblue';
			}
			else{
				fillStyle = 'darkblue';
			}
			ctx.rect(runningX, runningY, widthBoxX, widthBoxY);
			ctx.fillStyle = fillStyle;
			ctx.fillRect(runningX, runningY, widthBoxX, widthBoxY);
			ctx.lineWidth= lineWidth;
			ctx.strokeStyle= "lightblue";
			ctx.stroke();
			
			runningY -= incrementHeaderX;
			
			flipFlop ^=1;
			runningX+=widthBoxX;
			++idex;
			reset = idex % 5;
			if(reset == 0){
				runningX = startX;
				runningY += widthBoxY;
			}
		}
		ctx.closePath();
	}
	
	return{
		visualize: function(systemVizCentricArray){
			clusterValues.reset();  // reinitilizes top dictionary
			visualizeClustersOnCanvas.reset();
			clusterViewCoordinatesToSystemName.initArrays();
			
			canvasas.init();
			viz(systemVizCentricArray);
		},
		vizualizeNoInit: function(systemVizCentricArray){
			viz(systemVizCentricArray);
		}
	}
})();

/**
 * clusters on canvas
 */
var visualizeClustersOnCanvas = (function () {
	
	// private
	
	var distancePartitionMinConstant = 904398;  // sample closest cluster to centre
	var distancePartitionMaxConstant = 5004938249;  // sample farthest cluster from centre 
	var distanceIncrement = Math.floor(distancePartitionMaxConstant/distancePartitionMinConstant);
	
	var dictionaryPartitioning = 30;
	var distanceStep = distanceIncrement/dictionaryPartitioning;
	var pixelIncrement = 5;
	var incrementsDictionary;
	var clustersDictionary;
	var starsDictionary;
	var starTextDictionary;
	var workDictionary;
	var maxX;
	
	
	// public
	
	return{
		reset: function(){
			clustersDictionary = new buckets.Dictionary();	
		},
		resetTextDictionary: function(){
			starTextDictionary  = new buckets.Dictionary();
			maxX = 0;
		},
		init: function(){
			incrementsDictionary = new buckets.Dictionary();
						
			var increment = 0;
			for (var idex = 0; idex < dictionaryPartitioning; idex++){
				increment += pixelIncrement;
				var nextKey = Math.floor(distanceStep *  distancePartitionMinConstant * idex);
				incrementsDictionary.set(nextKey, increment);
			}
		},
		logPrint: function(){
			var keys = incrementsDictionary.keys();
			for(var idex = 0; idex < keys.length; idex++){
				var key = keys[idex];
				var value = incrementsDictionary.get(key);
				console.log("CLUSTER PARITION:"+value + " INCREMENT:" + key);
			}
		},
		locateScaleUsingDistance: function(distance, angle){	// distance in kilometers, angle in radians
			var pixelScalar;
			var keys = incrementsDictionary.keys();
			for(var idex = 0; idex < keys.length; idex++){
				var idex2 = idex + 1;
				if(idex2 == keys.length){
					pixelScalar = incrementsDictionary.get(keys[keys.length-1]);  // end of the keys
					break;
				}
				if(keys[idex]>= distance && keys[idex2] < distance){
					pixelScalar = incrementsDictionary.get(keys[idex]);
					break;
				}
			}
			pixelScalar = Math.floor(pixelScalar / 3);  // so as to compute from middle of the system visual.
			var pointFromCentre = scaledXandY.scaleToAngle(angle, pixelScalar);
			return pointFromCentre;
		},
		saveSystemClusterVizScalar: function(scalarX, scalarY, systemName, starsName, starColor){
			console.log("SAVE SYSTEM VIZ SCALAR:"+scalarX+"::"+scalarY+"::"+systemName+"::"+starsName+"::"+starColor+"::");
			if(!clustersDictionary.containsKey(systemName)){
				starsDictionary  = new buckets.Dictionary();
				clustersDictionary.set(systemName, starsDictionary)
			}
			starsDictionary = clustersDictionary.get(systemName);
			var o_starVizElements = new starVizElements();
			o_starVizElements.setScalarXandYandColor(scalarX, scalarY, starColor);
			starsDictionary.set(starsName, o_starVizElements);
			console.log("SAVE SYSTEM VIZ SCALAR KEYS:"+starsDictionary.keys());
		},
		fetchSystemClusterVizScalar: function(systemName){
			var o_starsDictionary = clustersDictionary.get(systemName);
			return o_starsDictionary;
		},
		fetchSystemNames: function(){
			return clustersDictionary.keys();
		},
		saveStarTextGeometry: function(starName, point){	// used to draw large selectable stars on page
			console.log("SAVE STAR TEXT GEOMETRY:"+starName+" X:"+point.getX()+" Y:"+point.getY());
			starTextDictionary.set(starName, point);
		},
		saveMaxX(xX){
			if( xX > maxX){
				maxX = xX;
			}
		},
		genStarTextGeomteryWithMaxX: function(){
			workDictionary = new buckets.Dictionary();
			var keys = starTextDictionary.keys();
			for(var idex = 0; idex < keys.length; idex++){
				var oo_point = starTextDictionary.get(keys[idex]);
				var o_point = new point();
				o_point.setXandY(Math.floor(maxX),oo_point.getY());
				workDictionary.set(keys[idex], o_point);
			}
		},
		fetchStarTextDictionary: function(){
			return workDictionary;
		}
	}
	
})();

/**
 * geometry to allow clickable stars, planets and moons on canvas
 */
var clickableAstroObjectList = (function(){
	
	var astroImageDictionary;
	const fudgeFactor = 3;  // close as in horseshoes ...
	
	var doTheAction;
	// private
	
	function action(nameAndKeys){
		doTheAction.init(nameAndKeys);
	}
	function starAndPlanetsAction(){
		doTheAction = starAndPlanets;
	}

	function planetAndMoonsAction(){
		doTheAction = planetAndMoons;
	}
	
	function moonsOnlyAction(){
		doTheAction = moonsOnly;
	}

	return{
		init: function(){
			astroImageDictionary = new buckets.Dictionary();
		},
		setStarsAndPlanets: function(){
			starAndPlanetsAction();
		},
		setPlanetAndMoons: function(){
			planetAndMoonsAction();
		},
		setMoonsOnly: function(){
			moonsOnlyAction();
		},
		addImageGeometry(xDim, yDim, radius, starName){
			var o_circle = new circle();
			o_circle.construct(xDim, yDim, radius);
			astroImageDictionary.set(starName, o_circle);
		},
		determineClick(clickedX, clickedY){
			var nameameKeys = astroImageDictionary.keys();
			for (var idex = 0; idex < nameameKeys.length; idex++){
				var o_circle = astroImageDictionary.get(nameameKeys[idex]);
				var bottom = o_circle.fetchBottom() + fudgeFactor;
				var top = o_circle.fetchTop() - fudgeFactor;
				var left = o_circle.fetchLeft() - fudgeFactor;
				var right = o_circle.fetchRight() + fudgeFactor;
				if(clickedX < right && clickedX > left && clickedY > top && clickedY < bottom){
					console.log("GOING TO:"+nameameKeys[idex] );
					action(nameameKeys[idex]);
				}
			}
		}
	}
	
})();

/**
 * visiualize star details and planets, if they exist.
 */
var starAndPlanets = (function(){
	
	return{
		init: function(starName){
			canvasas.clearStarSystemsCanvasContext();
			canvasas.clearStarsInClusterTextCanvasContext();
			var showList = ['backToSector'];
			tagOperations.show(showList);
			fetchStarAndPlanets.jsonCall(starName);
		}
	}
	
})();

var planetAndMoons = (function(){
	
	return{
		init: function(planetName){
			canvasas.clearStarSystemsCanvasContext();
			canvasas.clearStarsInClusterTextCanvasContext();
			var showList = ['backToStarSystem'];
			tagOperations.show(showList);
			var starName = sessionStorage.STAR_NAME;
			sessionStorage.setItem('PLANET_NAME', planetName);
			fetchPlanetAndMoons.jsonCall(planetName, starName);
		}
	}
	
})();

var moonsOnly = (function(){
	
	return{
		init: function(moonName){
			canvasas.clearStarSystemsCanvasContext();
			canvasas.clearStarsInClusterTextCanvasContext();
			var showList = ['backToPlanetSystem'];
			tagOperations.show(showList);
			var starName = sessionStorage.STAR_NAME;
			fetchMoons.jsonCall(moonName, starName);
		}
	}
	
})();


/**
 * star and planets detail
 */

var processStarAndPlanetsDetail = (function(){
	var scale = 1.0;	// the default scale
	const ANGLE_IN_RADIANS = "angle_in_radians_s";
	const DISTANCE_CLUSTER_VIRT_CENTRE = "distance_clust_virt_centre";
	const LUMINOSITY = "luminosity";
	const NAME = "Name";
	const STAR_COLOR = "star_color";
	const STAR_SIZE = "star_size";
	const STAR_TYPE = "star_type";
	const PLANETOID_NAME = "planetoidName";
	const DEGREE = "Degree"; // always in radians
	const DISTANCE_TO_PRIMARY = "DistanceToPrimary";
	const TEMPERATURE = "Temperature";
	const RADIUS = "Radius";
	const PLANAR_COLOR = "Color";
	const PLANAR_COLOR_PERCENTAGE = "Percent";
	const TEMPTYPE = "TempType";
	const SIZETYPE = "SizeType";
	const STARRENAME = "STARrenameName"
	const RENAMENAME = "renameName";
	
	const ELPISE_SCALAR = 90000;  // a segmenter for distances of 900 K kloms to 90,000 K kloms
	
	var o_clusterVizCentric;
	var planetsDictionary;
	var onePlanetDictionary;
	var o_planarVizCentric;
	var o_colorPercentageSet;
	var midX;
	var midY;
	const startX = 5;
	const startY = 50;
	var incrementY = 20;
	var offsetX = 80;
	var planetNames;

	function f_angle_in_radians(value){
		o_clusterVizCentric.setAnglenInRadians(value);
		console.log("AnglenInRadians: "+ value);
	}
	
	function f_distance_clust_virt_centre(value){
		o_clusterVizCentric.setDistanceClusterVirtCentre(value);
		console.log("DistanceClusterVirtCentre: "+ value);
	}
	
	function f_luminosity(value){
		o_clusterVizCentric.setLuminosity(value);
		console.log("luminosity: "+ value);
	}
	
	function f_starName(value){
		o_clusterVizCentric.setStarName(value);
		console.log("starName: "+ value);
	}
	
	function f_starColor(value){
		o_clusterVizCentric.setStarColor(value);
		console.log("starColor: "+ value);
	}
	
	function f_starSize(value){
		o_clusterVizCentric.setStarSize(value);
		console.log("starSize: "+ value);
	}drawStarInCentre
	
	function f_starType(value){
		o_clusterVizCentric.setStarType(value);
		console.log("starType: "+ value);
	}
	
	function f_planarName(value){
		console.log("planetoidName: "+ value);
		o_planarVizCentric = new planarVizCentric();
		o_planarVizCentric.setPlanarName(value);
		onePlanetDictionary.set(value, o_planarVizCentric);
	}
	
	function f_planarDegree(value){
		console.log("planarDegree: "+ value);
		o_planarVizCentric.setPlanarDegree(value);
	}
	
	function f_planarDistanceToPrimary(value){
		console.log("planarDistanceToPrimary: "+ value);
		o_planarVizCentric.setPlanarDistanceToPrimary(value);
	}
	
	function f_temperature(value){
		console.log("temperature: "+ value);
		o_planarVizCentric.setPlanarTemperature(value);
	}

	function f_radius(value){
		console.log("radius: "+ value);
		o_planarVizCentric.setPlanarRadius(value);
	}
	
	function f_tempType(value){
		console.log("tempType: "+ value);
		o_planarVizCentric.setPlanarTempType(value);
	}

	function f_sizeType(value){
		console.log("sizeType: "+ value);
		o_planarVizCentric.setPlanarSizeType(value);
	}
	
	function f_planarColor(value){
		o_colorPercentageSet = new colorPercentageSet();
		o_colorPercentageSet.setPlanarColor(value);
		console.log("planarColor: "+ value);
		
	}
	
	function f_planarColorPercentage(value){
		console.log("planarColorPercentage: "+ value);
		o_colorPercentageSet.setColorPercentage(value);
		o_planarVizCentric.addColorPercentage(o_colorPercentageSet);
	}
	
	function f_StarRename(renameValue){
		console.log("planarRename: "+ renameValue);
		o_clusterVizCentric.setRename(renameValue);
	}
 
	function f_planarRename(renameValue){
		console.log("planarRename: "+ renameValue);
		o_planarVizCentric.setRenameName(renameValue);
	}
	
	function parseResults(result){
		o_clusterVizCentric = new clusterVizCentric();
//		o_planarVizCentric = new planarVizCentric();
		planetsDictionary = new buckets.Dictionary();
		onePlanetDictionary = new buckets.Dictionary();  // all the planets for this star
		planetsDictionary.set(ANGLE_IN_RADIANS, f_angle_in_radians);
		planetsDictionary.set(DISTANCE_CLUSTER_VIRT_CENTRE, f_distance_clust_virt_centre);
		planetsDictionary.set(LUMINOSITY, f_luminosity);
		planetsDictionary.set(NAME, f_starName);
		planetsDictionary.set(STAR_COLOR, f_starColor);
		planetsDictionary.set(STAR_SIZE, f_starSize);
		planetsDictionary.set(STAR_TYPE, f_starType);
		planetsDictionary.set(PLANETOID_NAME, f_planarName);
		planetsDictionary.set(DEGREE, f_planarDegree);
		planetsDictionary.set(DISTANCE_TO_PRIMARY, f_planarDistanceToPrimary);
		planetsDictionary.set(TEMPERATURE, f_temperature);
		planetsDictionary.set(RADIUS, f_radius);
		planetsDictionary.set(TEMPTYPE, f_tempType);
		planetsDictionary.set(SIZETYPE, f_sizeType);
		planetsDictionary.set(PLANAR_COLOR, f_planarColor);
		planetsDictionary.set(PLANAR_COLOR_PERCENTAGE, f_planarColorPercentage);
		planetsDictionary.set(STARRENAME,f_StarRename);
		planetsDictionary.set(RENAMENAME,f_planarRename);
		
		for (var idex = 0; idex < result.length; idex++){
			var o_keyValuePair = result[idex];
			var key = o_keyValuePair.getKey();
			var operation = planetsDictionary.get(key);
			operation(o_keyValuePair.getValue());
		}
		
	}
	
	function drawStarInCentre(){
		var starColor = o_clusterVizCentric.getStarColor();
		var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
		midX = starsystemscanvasContext.canvas.width/2;
		midY = starsystemscanvasContext.canvas.height/6;
		var vizStarSizes = vizStars.fetchStarSizeAndColor(starColor);
		var size = vizStarSizes.fetchBigSize()*2*scale;
		var color = vizStarSizes.fetchColor();
		starsystemscanvasContext.beginPath();
		console.log("STAR:"+midX+"::"+midY+"::");
		starsystemscanvasContext.arc(midX, midY, size, 0, 2*Math.PI, false);
		starsystemscanvasContext.fillStyle = color;
		starsystemscanvasContext.fill();
		starsystemscanvasContext.lineWidth=0;
		starsystemscanvasContext.stroke();
	}
	
	function drawStarImage(){
		canvasas.initStarSystem();
		var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
		scaleViz.drawControls(starsystemscanvasContext);
		var starColor = o_clusterVizCentric.getStarColor();	
		var URL = vizStars.getImageURL()+vizStars.getImage(starColor);
		console.log("Image URL:"+URL);
		var img = new window.Image();
		var ctx = canvasas.fetchStarSystemsCanvasContext();
		img.onload = function(){
			  ctx.drawImage(img,0,500); 
			};
		img.src = URL;
		// ctx.drawImage(img, 500, 500);
	}
	
	function drawPlanetoidsAroundStar(){
		if(planetNames.length == 0){
			console.log("NO PLANETS");
			var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
			scaleViz.drawControls(starsystemscanvasContext);
		}
		else{
			var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
			// starsystemscanvasContext.save();
			scaleViz.drawControls(starsystemscanvasContext);

			var starColor = o_clusterVizCentric.getStarColor();

			for (var idex = 0; idex < planetNames.length; idex++){
				o_planarVizCentric = onePlanetDictionary.get(planetNames[idex]);
				var name = planetNames[idex];
				var distance = o_planarVizCentric.getPlanarDistanceToPrimary();
				console.log("PLANET "+ name + " DISTANCE:" + distance);
				var radiusOnPage = distance/ELPISE_SCALAR;
				if(radiusOnPage < 5){
					radiusOnPage = 5;
				}
				if(radiusOnPage > 500){
					radiusOnPage = 500;
				}
				var angleInDegrees = o_planarVizCentric.getPlanarDegree()*(180/Math.PI);  // radians to degrees
				
				o_point = new point();
				o_point.setXandY(midX, midY);
				ellipseWithPlanar.drawEllipseAndPlanar(o_point, radiusOnPage, angleInDegrees, starColor, starsystemscanvasContext);
			}
			// starsystemscanvasContext.restore();
		}
	}
	
	function drawStarDetails(){
		var starName = o_clusterVizCentric.getStarName();
		var distance = o_clusterVizCentric.getDistanceClusterVirtCentre();
		var angle = o_clusterVizCentric.getAnglenInRadians()*(180/Math.PI);
		var luminosity = o_clusterVizCentric.getLuminosity();
		var color = o_clusterVizCentric.getStarColor();
		var size = o_clusterVizCentric.getStarSize();
		var type = o_clusterVizCentric.getStarType();
		var renameName = o_clusterVizCentric.getRename();
		
		var ctx = canvasas.fetchStarsInClusterTextCanvasContext();
		var runningX = startX;
		var runningY = startY;
		var incrementY = 20;
		ctx.font="18px Verdana";
		ctx.strokeStyle = "orange";
		ctx.strokeText("Star System "+starName+ " " + renameName + " Details", runningX, runningY);
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Select Planet By Planet Image", runningX, runningY);
		runningY += incrementY;
		runningX = startX;
		
		ctx.font="14px Verdana";
		ctx.strokeStyle = "lightblue";
		ctx.strokeText("Distance to Cluster Centre:"+distance, runningX, runningY);
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Angle in Cluster:"+angle, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Luminosity:"+luminosity, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Star Color:"+color, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Star Size:"+size, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Star Type:"+type, runningX, runningY);		
		drawPlanetDetails(startX, runningY);
	}
	
	function debugPlanetDetails(){
		var planetNames = onePlanetDictionary.keys();
		for (var idex = 0; idex < planetNames.length; idex++){
			console.log("PLANET next:" + planetNames[idex]);
			
			o_planarVizCentric = onePlanetDictionary.get(planetNames[idex]);
			console.log("NAME next:" + o_planarVizCentric.getPlanarName());
		}
	}
	
	function drawPlanetDetails(startX, runningY){
		var ctx = canvasas.fetchNewStarAndPlanetsContext();
		var planetNames = onePlanetDictionary.keys();
		var runningX = startX;
		if(planetNames.length == 0){
			ctx.font="14px Verdana";
			ctx.strokeStyle = "orange";

			runningY += (incrementY * 3);
			ctx.strokeText("Star does not have planets", runningX, runningY);
			runningY += incrementY;
			runningX = startX;
			ctx.strokeText("Select Re-Enter Sector Control and select a different star", runningX, runningY);
		}
		else{
			runningX = startX;
			runningY += incrementY;
			ctx.strokeText("Star has:"+planetNames.length+" planet(s)", runningX, runningY);		

			clickableAstroObjectList.init();
			clickableAstroObjectList.setPlanetAndMoons();
			runningY += incrementY*2;
			// debugPlanetDetails();
			for (var idex = 0; idex < planetNames.length; idex++){
				runningX = startX;
				o_planarVizCentric = onePlanetDictionary.get(planetNames[idex]);
				o_planarVizCentric.buildGradients();
				var name = o_planarVizCentric.getPlanarName();
				var degree = o_planarVizCentric.getPlanarDegree()*(180/Math.PI);  // to degrees
				var distance = o_planarVizCentric.getPlanarDistanceToPrimary();
				var temperature = o_planarVizCentric.getPlanarTemperature();
				var radius = o_planarVizCentric.getPlanarRadius();
				var renameName = o_planarVizCentric.getRenameName();
				ctx.font="14px Verdana";
				ctx.strokeStyle = "yellow";
				var planarName = "Planar Name: "+name;
				ctx.strokeText(planarName, runningX, runningY);
				if(renameName != ""){
					runningY += incrementY;
					ctx.strokeText(renameName, runningX, runningY);
				}
				
				var imageX = Math.floor(ctx.measureText(planarName).width + offsetX);
				var outerRadius = vizPlanars.fetchImageSize(radius);
				var gradientsArray = o_planarVizCentric.fetchGradients();
				buildCircleGradient(ctx, outerRadius, imageX, runningY, imageX, runningY, gradientsArray);
				clickableAstroObjectList.addImageGeometry(imageX, runningY, outerRadius, planetNames[idex]);
				
				runningY += incrementY;
				runningX = startX;
				ctx.strokeStyle = "lightblue";
				ctx.strokeText("Planar Position in Degrees: "+degree, runningX, runningY);
				runningY += incrementY;
				runningX = startX;
				ctx.strokeText("Planar Distance to Star: "+distance, runningX, runningY);
				runningY += incrementY;
				runningX = startX;
				ctx.strokeText("Planar Kelvin Temperature: "+temperature, runningX, runningY);
				runningY += incrementY;
				runningX = startX;
				ctx.strokeText("Planar Radius in Kilometers: "+radius, runningX, runningY);
				runningY += incrementY*2;
			}

		}

	}
	
	function buildCircleGradient(context, radius, xStart, yStart, xEnd, yEnd, gradientsArray){
		var gradient = context.createLinearGradient(xStart-radius, yStart-radius, xEnd+radius, yEnd+radius);
		var gradientsArray = o_planarVizCentric.fetchGradients();
		for(var idex2 = 0; idex2 < gradientsArray.length; idex2++){
			var percent = gradientsArray[idex2].getGradientPercentage();
			var color = gradientsArray[idex2].getColor();
			gradient.addColorStop(percent, color);
		}
		context.beginPath();
		context.arc(xStart, yStart, radius, 0, 2*Math.PI);
		context.fillStyle = gradient;  // not working ... err ... works with new canvas 
		context.fill();
		context.stroke();
		context.closePath();

	}
	
	return{
		jsonProcess: function(json, starName){
			// print_recursive(json);
			
			console.log("JSON: "+json.planets.starAndPlanets);
			var starAndPlanetsMessage = json.planets.starAndPlanets;
			var result = orderedPairToArray.getOrderedPair(starAndPlanetsMessage);
			
			parseResults(result);
			scaleViz.setModePlanets();
			planetNames = onePlanetDictionary.keys(); // early binding for scale processing
			drawStarInCentre();
			drawPlanetoidsAroundStar();
			drawStarDetails();
			sessionStorage.setItem('STAR_NAME', starName);	// used to find atmosphere color of moons
		},
		setScale: function(n_scale){
			scale = n_scale;
		},
		getScale: function(){
			return scale;
		},
		f_drawStarInCentre: function(){
			drawStarInCentre();
		},
		f_drawPlanetoidsAroundStar: function(){
			drawPlanetoidsAroundStar();
		},
		f_drawStarImage: function(){
			drawStarImage();
		},
		f_drawStarDetails: function(){
			drawStarDetails();
		},
		f_getPlanarDetails(){
			return o_planarVizCentric;
		},
		f_circleGradient(context, radius, xStart, yStart, xEnd, yEnd, gradientsArray){
			buildCircleGradient(context, radius, xStart, yStart, xEnd, yEnd, gradientsArray);
		},
		f_fetchClusterVizCentric(){
			return o_clusterVizCentric;
		}
	}
	
})();

/**
 * planet and moon detail
 */

var processPlanetAndMoonsDetail = (function(){
	var scale = 1.0;	// the default scale
	const DEGREE = "Degree";
	const DISTANCE_TO_PRIMARY = "DistanceToPrimary";
	const PERCENT_WATER = "PercentWater";
	const TEMPERATURE = "Temperature";
	const RADIUS = "Radius";
	const PLANAR_NAME = "planetoidName";
	const ACTION = "ACTION";
	const ATMOSPHERE = "ATMOSPHERE";
	const NO_MOON = "NO_MOON";
	const MOON = "MOON";
	const CHEM_NAME = "chem_name";
	const PERCENTAGE = "percentage";
	const CHEM_COLOR = "Chem_Color";
	const PERCENT = "Percent";
	const COLOR = "Color";
	const TEMPTYPE = "TempType";
	const SIZETYPE = "SizeType";
	const RENAMENAME = "renameName";

	
	const o_planarVizCentric = new planarVizCentric();
	const startX = 5;
	const startY = 50;
	const atmospherRectX = 250;
	const xOffset = 10;
	const imageX = 500;
	const incrementY = 20;
	const MOON_TO_EARTH = 384400.0;
	const ELIPSE_MOON_SCALAR = 22115.0*MOON_TO_EARTH;

	var o_moonPlanarVizCentric;
	var onePlanetDictionary;
	var o_colorPercentageSet;
	var o_atmosphereArray;
	var o_atmosphereSet;
	
	var planetAndMoonsDictionary;
	var moonsDictionary;
	var planetDictionary;
	
	var midX;
	var midY;
	
	var o_baseMessage;
	var moonNames;
	
	baseMessage = function(){
		var planarMessage;
		this.planarMessage = "error, not initialized";
		var emptyMessage;
		this.emptyMessage = "error, not initialized";
		var selectMessage;
		this.selectMessage = "error, not initialized";
		var fromMessage;
		this.fromMessage = "error, not initialized";
	}
	baseMessage.prototype.Planet = function(){
		this.planarMessage = "Planet";
		this.emptyMessage = "Planet does not have any moons";
		this.selectMessage = "Select Moon by Moon Image";
		this.fromMessage = "Star";
	}
	baseMessage.prototype.Moon = function(){
		this.planarMessage = "Moon";
		this.emptyMessage = "Moon does not have satellites";
		this.selectMessage = "No Satellites To Select";
		this.fromMessage = "Planet";
	}
	baseMessage.prototype.getMode = function(){
		return this.planarMessage;
	}
	baseMessage.prototype.getEmpty = function(){
		return this.emptyMessage;
	}
	baseMessage.prototype.getSelect = function(){
		return this.selectMessage;
	}
	baseMessage.prototype.getFrom = function(){
		return this.fromMessage;
	}
	
	function planetDegree(value){
		o_planarVizCentric.setPlanarDegree(value);
		console.log("planetDegree: "+ value);
	}
	
	function planetDistanceToPrimary(value){
		o_planarVizCentric.setPlanarDistanceToPrimary(value);
		console.log("planetDistanceToPrimary: "+ value);
	}
	
	function planetRadius(value){
		o_planarVizCentric.setPlanarRadius(value);
		console.log("planetRadius: "+ value);
	}
	
	function planetPercentWater(value){
		o_planarVizCentric.setPlanarPercentWater(value);
		console.log("planetPercentWater: "+ value);
	}
	
	function planetTemperature(value){
		o_planarVizCentric.setPlanarTemperature(value);
		console.log("planetTemperature: "+ value);
	}
	function tempType(value){
		console.log("tempType: "+ value);
		o_planarVizCentric.setPlanarTempType(value);
	}

	function sizeType(value){
		console.log("sizeType: "+ value);
		o_planarVizCentric.setPlanarSizeType(value);
	}
	
	function planetName(value){
		o_planarVizCentric.setPlanarName(value);
		console.log("planetName: "+ value);
	}
	
	function atmosphereChemName(value){
		o_atmosphereSet = new atmosphereSet();
		o_atmosphereSet.setChemical(value);
		console.log("planetAtmosphereChemName: "+ value);
	}

	function atmosphereChemPercentage(value){
		o_atmosphereSet.setPercentage(value);
		console.log("planetAtmosphereChemPercentage: "+ value);
	}
	
	function atmosphereChemColor(value){
		o_atmosphereSet.setColor(value);
		o_atmosphereArray.push(o_atmosphereSet)
		console.log("planetAtmosphereChemColor: "+ value);
	}
	
	function p_planarRename(s_rename){
		o_planarVizCentric.setRenameName(s_rename);
		console.log("planetRename: "+ s_rename);
	}

	
	function action(value){
		console.log("action: "+ value);
		if(value == 'NO_MOON'){
			console.log("No moons for this planar");
		}
		else{
			if(value == 'MOON'){
				planetAndMoonsDictionary = moonsDictionary;
			}
			else{
				if(value == 'ATMOSPHERE'){
					console.log("atmospheres coming");					
				}
				else{
					throw "Bad Action Value:"+value;planarRename
				}
			}
		}
	}
	
	function moonName(value){
		console.log("moonName: "+ value);
		o_moonPlanarVizCentric = new planarVizCentric();
		o_moonPlanarVizCentric.setPlanarName(value);
		onePlanetDictionary.set(value, o_moonPlanarVizCentric);
	}
	
	function moonDegree(value){
		o_moonPlanarVizCentric.setPlanarDegree(value);
		console.log("moonDegree: "+ value);
	}
	
	function moonRadius(value){
		o_moonPlanarVizCentric.setPlanarRadius(value);
		console.log("moonRadius: "+ value);
	}

	function moonDistanceToPrimary(value){
		o_moonPlanarVizCentric.setPlanarDistanceToPrimary(value);
		console.log("moonDistanceToPrimary: "+ value);
	}
	
	function moonTemperature(value){
		o_moonPlanarVizCentric.setPlanarTemperature(value);
		console.log("moonTemperature: "+ value);
	}
	
	function moonColor(value){
		o_colorPercentageSet = new colorPercentageSet();
		o_colorPercentageSet.setPlanarColor(value);
		console.log("moonColor: "+ value);
	}
	
	function moonColorPercentage(value){
		o_colorPercentageSet.setColorPercentage(value);
		o_moonPlanarVizCentric.addColorPercentage(o_colorPercentageSet);
		console.log("moonColorPercentage: "+ value);
	}
	
	function f_planarRename(s_rename){
		o_moonPlanarVizCentric.setRenameName(s_rename);
		console.log("moonRename: "+ s_rename);
	}

	function parseResults(result){
		planetDictionary = new buckets.Dictionary();
		moonsDictionary = new buckets.Dictionary();
		onePlanetDictionary = new buckets.Dictionary();	// all the moons around the planet
		o_atmosphereArray = [];
		
		planetAndMoonsDictionary = planetDictionary;	// planet messages come first
		planetDictionary.set(DEGREE, planetDegree);
		planetDictionary.set(DISTANCE_TO_PRIMARY, planetDistanceToPrimary);
		planetDictionary.set(PERCENT_WATER, planetPercentWater);
		planetDictionary.set(TEMPERATURE, planetTemperature);
		planetDictionary.set(PLANAR_NAME, planetName);
		planetDictionary.set(RADIUS, planetRadius);
		planetDictionary.set(TEMPTYPE, tempType);
		planetDictionary.set(SIZETYPE, sizeType);
		planetDictionary.set(ACTION, action);
		planetDictionary.set(CHEM_NAME, atmosphereChemName);
		planetDictionary.set(PERCENTAGE, atmosphereChemPercentage);
		planetDictionary.set(CHEM_COLOR, atmosphereChemColor);
		planetDictionary.set(RENAMENAME, p_planarRename);

		
		moonsDictionary.set(PLANAR_NAME, moonName);
		moonsDictionary.set(DEGREE, moonDegree);
		moonsDictionary.set(RADIUS, moonRadius);
		moonsDictionary.set(TEMPTYPE, tempType);
		moonsDictionary.set(SIZETYPE, sizeType);
		moonsDictionary.set(DISTANCE_TO_PRIMARY, moonDistanceToPrimary);
		moonsDictionary.set(TEMPERATURE, moonTemperature);
		moonsDictionary.set(COLOR, moonColor);
		moonsDictionary.set(PERCENT, moonColorPercentage);
		moonsDictionary.set(RENAMENAME, f_planarRename);
		
		for (var idex = 0; idex < result.length; idex++){
			var o_keyValuePair = result[idex];
			var key = o_keyValuePair.getKey();
			// console.log("KEY:"+key);
			var operation = planetAndMoonsDictionary.get(key);
			operation(o_keyValuePair.getValue());
		}
		
	}
	
	function drawPlanetInCentre(){
		var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
		midX = starsystemscanvasContext.canvas.width/2;
		midY = starsystemscanvasContext.canvas.height/6;
		var radius = o_planarVizCentric.getPlanarRadius();
		var outerRadius = vizPlanars.fetchImageSize(radius);
		var gradientsArray = o_planarVizCentric.fetchGradients();
		processStarAndPlanetsDetail.f_circleGradient(starsystemscanvasContext, outerRadius, midX, midY, midX, midY, gradientsArray);

	}
	
	function drawPlanetDetails(){
		var planarType = o_baseMessage.getMode();
		var fromMessage = o_baseMessage.getFrom();
		var planarName = o_planarVizCentric.getPlanarName();
		var rename = o_planarVizCentric.getRenameName();
		var planarDegree = o_planarVizCentric.getPlanarDegree()*(180/Math.PI);  // radians to degrees
		var distanceToParentStar = o_planarVizCentric.getPlanarDistanceToPrimary();
		var temperature = o_planarVizCentric.getPlanarTemperature();	// kelvin
		var radius = o_planarVizCentric.getPlanarRadius();
		var percentageWater = o_planarVizCentric.getPlanarPercentWater();
		var tempType = o_planarVizCentric.getPlanarTempType();
		var sizeType = o_planarVizCentric.getPlanarSizeType();
		
		var ctx = canvasas.fetchStarsInClusterTextCanvasContext();
		var runningX = startX;
		var runningY = startY;
		
		ctx.font="18px Verdana";
		ctx.strokeStyle = "orange";
		ctx.strokeText(planarType +" "+planarName+ "  " + rename + " Details", runningX, runningY);
		runningY += incrementY;
		runningX = startX;
		var selectMessage = o_baseMessage.getSelect();
		ctx.strokeText(selectMessage, runningX, runningY);
		runningY += incrementY;
		runningX = startX;

		ctx.font="14px Verdana";
		ctx.strokeStyle = "lightblue";
		ctx.strokeText(planarType +" Angle from "+fromMessage+": "+planarDegree, runningX, runningY);
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText(planarType +" Distance from "+fromMessage+": "+distanceToParentStar, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText(planarType +" Temperature Kelvin: "+temperature, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText(planarType + " Radius in Kilometers: "+radius, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText(planarType + " Temperature Type: "+tempType, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText(planarType + " Size Type: "+sizeType, runningX, runningY);		
		runningY += incrementY;
		runningX = startX;
		ctx.strokeText("Percentage Water of "+ planarType +": "+percentageWater*100, runningX, runningY);	
		
		runningY += incrementY;
		runningX = startX;
		if(moonNames.length == 0){
			var emptyMessage = o_baseMessage.getEmpty();
			ctx.strokeText(emptyMessage, runningX, runningY);
		}
		else{
			if(moonNames.length == 1){
				ctx.strokeText("Planet has one moon", runningX, runningY);
			}
			else{
				ctx.strokeText("Planet has "+ moonNames.length+ " moons", runningX, runningY);
			}
		}
		runningX = startX;
		runningY += incrementY;
		runningY += incrementY;
		runningY += incrementY;
		runningY += incrementY;
		var snatchY = runningY;
		for (var idex=o_atmosphereArray.length-1; idex > -1; idex--){
			var o_atmosphereSet = o_atmosphereArray[idex];
			var name = o_atmosphereSet.getChemical();
			var percent = Number(o_atmosphereSet.getPercentage())*100;
			var color = o_atmosphereSet.getColor();
			ctx.strokeText("Atmosphere: "+name, startX , runningY);	
			runningY += incrementY;
			ctx.strokeText("Percent: "+percent, startX , runningY);	
			runningY += incrementY;
			ctx.beginPath();
			ctx.fillStyle=color;
			var atmospherRectY = o_atmosphereSet.getYVisualSize(percent);
			ctx.fillRect(startX, runningY, atmospherRectX, atmospherRectY);
			ctx.stroke();
			runningY += atmospherRectY;
			runningY += incrementY;
		}
		if(moonNames.length > 0){
			console.log("NUMBER OF MOONS:"+moonNames.length);
			drawMoonSelectables(moonNames, snatchY);
			drawMoonsAroundPlanets(moonNames)
		}

	}
	
	function drawMoonsAroundPlanets(moonNames){
		var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
		scaleViz.drawControls(starsystemscanvasContext);
		midX = starsystemscanvasContext.canvas.width/2;
		midY = starsystemscanvasContext.canvas.height/6;
		var o_clusterVizCentric = processStarAndPlanetsDetail.f_fetchClusterVizCentric();
		var starColor = o_clusterVizCentric.getStarColor();
		var starsystemscanvasContext = canvasas.fetchStarSystemsCanvasContext();
		for (var idex = 0; idex < moonNames.length; idex++){
			var o_moonPlanarVizCentric = onePlanetDictionary.get(moonNames[idex]);
			var distance = o_moonPlanarVizCentric.getPlanarDistanceToPrimary();
			var radiusOnPage = moonViz.computeMoonVizRadius(distance);
			var angleInDegrees = o_moonPlanarVizCentric.getPlanarDegree()*(180/Math.PI);
			o_point = new point();
			o_point.setXandY(midX, midY);
			ellipseWithPlanar.drawEllipseAndPlanar(o_point, radiusOnPage, angleInDegrees, starColor, starsystemscanvasContext);
		}
	}
	
	function drawMoonSelectables(moonNames, runningY){
		var ctx = canvasas.fetchNewStarAndPlanetsContext();
		clickableAstroObjectList.init();
		clickableAstroObjectList.setMoonsOnly();
		for(var idex = 0; idex < moonNames.length; idex++){
			var o_moonPlanarVizCentric = onePlanetDictionary.get(moonNames[idex]);
			o_moonPlanarVizCentric.buildGradients();
			var radius = o_moonPlanarVizCentric.getPlanarRadius();
			var outerRadius = vizPlanars.fetchImageSize(radius);
			var gradientsArray = o_moonPlanarVizCentric.fetchGradients();
			processStarAndPlanetsDetail.f_circleGradient(ctx, outerRadius, imageX, runningY, imageX, runningY, gradientsArray);

			clickableAstroObjectList.addImageGeometry(imageX, runningY, outerRadius, moonNames[idex]);
			runningY += (incrementY*6);
		}
	}
	
	return{
		init: function(){
			o_baseMessage = new baseMessage();
		},
		jsonProcess: function(json, planetName){
			var planetAndMoonsMessage = json.planets.planetAndMoons;
			console.log("PLANET AND MOONS MESSAGE:"+planetAndMoonsMessage);
			var result = orderedPairToArray.getOrderedPair(planetAndMoonsMessage);
			parseResults(result);
			moonNames = onePlanetDictionary.keys();	// early binding
			scaleViz.setModeMoons();
			drawPlanetDetails();
			drawPlanetInCentre();
		},
		f_drawPlanetDetails: function(){
			drawPlanetDetails();
		},
		f_drawPlanetInCentre: function(){
			drawPlanetInCentre();
		},
		f_drawMoons: function(){
			drawMoonsAroundPlanets(moonNames);
		},
		f_planetMode: function(){
			o_baseMessage.Planet();
		},
		f_moonMode: function(){
			o_baseMessage.Moon();
		},
		f_getMode: function(){
			o_baseMessage.getMode();
		}
		
	}
})();


var backToStarView  = (function (){
	
	return{
		reenter: function(){
			var hideList = ['backToStarSystem','backToPlanetSystem'];
			tagOperations.hide(hideList);
			
			canvasas.clearStarSystemsCanvasContext();
			canvasas.clearStarsInClusterTextCanvasContext();
			canvasas.init();
			scaleViz.setModePlanets();
			processStarAndPlanetsDetail.f_drawStarInCentre();
			processStarAndPlanetsDetail.f_drawPlanetoidsAroundStar();
			processStarAndPlanetsDetail.f_drawStarDetails();
			
		}
	}
	
})();

var backToPlanetView = (function(){
	
	return{
		reenter: function(){
			var hideList = ['backToPlanetSystem'];
			tagOperations.hide(hideList);
			canvasas.clearStarSystemsCanvasContext();
			canvasas.clearStarsInClusterTextCanvasContext();
			canvasas.init();
			scaleViz.setModeMoons();
			var planetName = sessionStorage.PLANET_NAME;  // restore via database
			var starName = sessionStorage.STAR_NAME;
			fetchPlanetAndMoons.jsonCall(planetName, starName);
		}
	}
	
})();

//for debugging
function print_recursive(printthis) {
    var output = '';

    if($.isArray(printthis) || typeof(printthis) == 'object') {
        for(var i in printthis) {
        	console.log("??:"+printthis[i]+"::"+i);
            output += i + ' : ' + print_recursive(printthis[i]) + '\n';
        }
    }else {
        output += printthis;
    }
    console.log("PRINT:"+output);
}
