using UnityEngine;
using System.Collections;

public class TekiController : MonoBehaviour {

	public float x=0.1f;
	public float speed=0.1f;
	public bool flag=true;
	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
		transform.position = new Vector3 (x, transform.position.y, transform.position.z);
		if (flag) {
			x += speed;
		}
		else {
			x-=speed;
		}
		if (x > 5.0) {
			x = 5.0f;
			flag = false;
		}
		if (x < -5.0) {
		x = -5.0f;
		flag = true;
		}

	}
}
