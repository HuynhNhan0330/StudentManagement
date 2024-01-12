import React, { useState, useEffect } from 'react';
import ScoreBoard from '../../../components/User/ScoreBoard/ScoreBoard'
import { handleGetScoreByStudent } from '../../../controller/ScoreController';

function ScorePage(){
    // Table:
    const [data, setData] = useState([]);
    const [user, setUser] = useState(localStorage.getItem('account'));

    const fetchData = () => {
        handleGetScoreByStudent(user.maSV).then((results) => {
            if (results == null) {
                results = [];
            }         

            setData(results);
        });
    };

    useEffect(() => {
        fetchData();
    }, [user]);

    // end

    return(
        <>
            <ScoreBoard StudentScoreData={data}></ScoreBoard>
        </>
    )
}
export default ScorePage;