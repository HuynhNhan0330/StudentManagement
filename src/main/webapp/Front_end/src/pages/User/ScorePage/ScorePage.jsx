import ScoreBoard from '../../../components/User/ScoreBoard/ScoreBoard'

function ScorePage(){
    let StudentScoreData = [];
    return(
        <>
            <ScoreBoard StudentScoreData={StudentScoreData}></ScoreBoard>
        </>
    )
}
export default ScorePage;