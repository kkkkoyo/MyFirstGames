using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;

public class SeisanController : MonoBehaviour {


	CharacterController controller;
	Animation animator;
	AnimationState[] sta;

	Vector3 moveDirection=Vector3.zero;

	public float speedX;
	public float gravity;
	public float speedZ;
	public float speedJump;
	const int Minline = -8;
	const int Maxline = 8;
	const float LaneWidth = 2.5f; //4.0f
	const int defaultLife=5;
	float targetLane;
	const float StumDuration = 0.9f;
	int life=defaultLife;
	float recoverTime=0.0f;
	int scoreM=0;

	public int Life(){
		
		return life;
	}

	public bool IsStan(){
	
		return recoverTime > 0.0f || life <= 0;
	}

	// Use this for initialization
	void Start () {
	//コンポーネント自動取得
		sta = new AnimationState[4];
		controller=GetComponent<CharacterController>();
		animator= GetComponent<Animation> ();
		foreach (AnimationState state in animator) {
			state.speed = 0.5F;
		}
	}
	
	// Update is called once per frame
	void Update () {

		scoreM=(int)transform.position.z/10;
		PlayerPrefs.SetInt("AllScore",scoreM); //重要
		if(Input.GetKeyDown("left")) MoveToLeft();
		if(Input.GetKeyDown("right")) MoveToRight();

		if (life == 0) {
			StartCoroutine(gameOver());
		
		}

		if (IsStan ()) {
		
			//動きを止め気絶状態からの復帰カウントを進める
			moveDirection.x = 0.0f;
			moveDirection.y = 0.0f;
			moveDirection.z = 0.0f;
			recoverTime -= Time.deltaTime;
		}else { 
//		if (Input.GetAxis ("Vertical") > 0.0f) {
//			moveDirection.z = Input.GetAxis ("Vertical") * speedZ;
//			Time.timeScale=4;
//			animator.Play("Walk");
//			}
//			else {
			moveDirection.z = speedZ; //キーなし動作
			//moveDirection.z =0;
			Time.timeScale = 3;
			animator.Play ("Walk");
			//}
			float ratioX = (targetLane * LaneWidth - transform.position.x) / LaneWidth;
			moveDirection.x = ratioX * speedX;
		}


		//重力分の力をmyフレームごとに追加
		moveDirection.y-=gravity*Time.deltaTime;

		//方向転換 
		//transform.Rotate(0,Input.GetAxis("Horizontal")*3,0);

		//移動実行
		Vector3 globalDirection = transform.TransformDirection (moveDirection);
		controller.Move (globalDirection * Time.deltaTime);

		//速度0以上なら走っているフラグをtrueにする
		//animator.
		if (Input.GetKeyDown ("space")) {
			Attack ();
		}

	}
	public void Attack(){
		if (IsStan ()) return;
		animator.Play("Attack");
		recoverTime = 0.3f;
	}


	public void MoveToLeft(){
		if (IsStan ()) return;
		if(controller.isGrounded&&targetLane>Minline) targetLane-=0.5f;
		if (targetLane < -2) targetLane = -2;
	}
	public void MoveToRight(){
		if (IsStan ()) return;
		if(controller.isGrounded&&targetLane>Minline) targetLane+=0.5f;
		if (targetLane > 2) targetLane = 2;

	}


	//当たり判定（物理演算）
	void OnCollisionEnter(Collision collision)
	{
		switch (collision.transform.tag)
		{

		case "mono":
			if (animator.IsPlaying("Attack")) {
				Destroy (collision.gameObject);
			}

			break;
//		case "Floor"://床に当たった時
//			//ジャンプアニメーションを切る
//			//TODO
//			playeranimator.SetBool("Jump", false);
//			col.center = new Vector3(0, 0.5f, 0);//アニメーションに合わせてcollisionの中心変える
//			jumpFlag = false;//ジャンプフラグを折る
//			break;
//		case "Uni"://うにに当たった時
//			state.Speed = 0;//ゲームのスピードを0にする（ゲームオーバー）
//			//ゲームオーバーアニメーションに切り替える
//			//TODO
//			playeranimator.SetBool("GameOver", true);
//			collision.gameObject.GetComponent<Renderer>().enabled = false;//当たったうにうにを見えなくする（見えたまんまだと蜂の巣になる）
//			PlayerPrefs.SetInt("PLAYERSCORE", state.Score);//スコアの保存
//			StartCoroutine(gameOver());//コルーチンの開始
//			break;
		}
	}

	//当たり判定（計算のみ）
	void OnTriggerEnter(Collider collider)
	{
		switch (collider.transform.tag) {
		case "Coin"://コインに当たった時
			Destroy(collider.gameObject);//当たったコインを消す
			life++;//スコアを１加算
			//state.ScoreTextUpdater();//スコアのテキストを更新
			break;
//		
		case "teki":
			//ライフを減らして気絶状態へ移行
			life--;
			if (life == 0) {
				animator.Play ("Dead");
			} else {
				animator.Play ("Damage");
			}
			recoverTime = StumDuration;
			//ダメージトリガーを設定
			Destroy (collider.gameObject);
			break;
	
		case "ana":
			if (IsStan ()) return;
			//ライフを減らして気絶状態へ移行
			animator.Play ("Dead");
			life=0;
			recoverTime = StumDuration;
			break;
		
	}
	}
	//CharacterControllerにコリジョンが生じたときの処理
	void OnControllerColliderHit(ControllerColliderHit hit){

		if (IsStan ()) return;

		if (hit.gameObject.tag == "teki") {
		}


	}

	//ゲームオーバー時に始まるコルーチン
	IEnumerator gameOver()
	{
		yield return new WaitForSeconds(3);//3秒待つ
		SceneManager.LoadScene("GameOverScene");//ResultSceneに遷移
	}
		
}
