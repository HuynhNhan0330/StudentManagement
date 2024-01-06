import ScoreBoard from '../../../components/User/ScoreBoard/ScoreBoard'
function ScorePage(){
    let creditLogs = {
        "semester II 2020-2021":
          [
            {
              id: "SE001",
              name: "Software Engineering",
              scores: [9, 9, 9, 9, 9],
              status: "passed",
            }
          ],
        "semester III 2020-2021": [
          {
            id: "SE001",
            name: "Software Engineering",
            scores: [9, 9, 9, 9, 9],
            status: "passed",
          },
          {
            id: "SE001",
            name: "Software Engineering",
            scores: [9, 9, 9, 9, 9],
            status: "passed",
          },
          {
            id: "SE001",
            name: "Software Engineering",
            scores: [9, 9, 9, 9, 9],
            status: "passed",
          }
        ],
        "semester IV 2020-2021": [
          {
            id: "SE001",
            name: "Software Engineering",
            scores: [9, 9, 9, 9, 9],
            status: "passed",
          }
        ]
      }
    
      function generateChildren(row) {
        let scores = [9, 9, 9, 9, 9]
    
        let myScoreItem = {
          key: '-1',
          subject_id: row?.id,
          subject_name: row?.name,
          status: row?.status,
        }
    
        for (var i = 0; i < scores.length; i++) {
          switch (i) {
            case 0:
              myScoreItem.progress_score = scores[i];
              break;
            case 1:
              myScoreItem.midterm_score = scores[i];
              break;
            case 2:
              myScoreItem.practice_score = scores[i];
              break;
            case 3:
              myScoreItem.finalterm_score = scores[i];
              break;
            case 4:
              myScoreItem.average_score = scores[i];
              break;
            default:
              break;
          }
        }
        return myScoreItem;
      }
    
      let datas = []
    
      for (let [semester, rows] of Object.entries(creditLogs)) {
        console.log(JSON.stringify(rows))
        let myRows = rows?.map(row => generateChildren(row))
        console.log(JSON.stringify(myRows))
        datas.push({
          key: semester,
          No_: semester,
          children: myRows
        });
      }
    
      const StudentScoreData = datas
    return(
        <>
            <ScoreBoard StudentScoreData={StudentScoreData}></ScoreBoard>
        </>
    )
}
export default ScorePage;