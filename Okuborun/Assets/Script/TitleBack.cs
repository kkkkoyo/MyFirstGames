using UnityEngine;
using System.Collections;

public class TitleBack : MonoBehaviour {

	public void OnButtonBackClicked ()
	{	
		
		Application.LoadLevel("MenuScene");
	}
}
