import './Userinformation.scss'
import ScoreBoard from '../ScoreBoard/ScoreBoard';


function UserInformation(props) {
    return (
        <div className='MainContainEr'>
            <div className="UserPic">
                <img className='userPicture' src={props.Avatar} />
            </div>
            <div className='UserBasicInfor'>
                <ul class="list-group">
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Full name: </span> {props.Full_name}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Student ID: </span> {props.Student_ID}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Date of birth: </span> {props.DateOfBirth}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Gender: </span>{props.Gender}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Phone number: </span> {props.Phone_number}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Program: </span> {props.Program}</li>
                    <li class="list-group-item" id='inforItem'><span className='title_infor_item'>Faculty: </span>{props.Faculty}</li>
                </ul>

            </div>

            
        </div>
    )
}
export default UserInformation;