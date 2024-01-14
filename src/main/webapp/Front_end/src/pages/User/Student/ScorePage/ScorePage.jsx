import React, { useState, useEffect } from 'react';
import ScoreBoard from '../../../../components/User/ScoreBoard/ScoreBoard'
import { handleGetScoreByStudent } from '../../../../controller/ScoreController';
import './ScorePage.scss'
function ScorePage(){
    // Table:
    const [data, setData] = useState([]);
    const [user, setUser] = useState(JSON.parse(localStorage.getItem('account')));

    const fetchData = () => {
        setUser(JSON.parse(localStorage.getItem('account')));
        handleGetScoreByStudent(user.maSV).then((results) => {
            if (results == null) {
                results = [];
            }         

            setData(results);
        });
    };

    useEffect(() => {
        fetchData();
    }, []);

    // end

    return(
        <>
        <div className='ScoreBoardContainerStudent'>
            <ScoreBoard classListData={data}></ScoreBoard>
        </div>
            
        </>
    )
}
export default ScorePage;