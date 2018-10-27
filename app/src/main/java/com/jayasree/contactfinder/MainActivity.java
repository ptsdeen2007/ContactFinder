package com.jayasree.contactfinder;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        if (dbHelper.getCount() == 0) {
            dbHelper.insertContact("Ernad", "Anakkayam", "Village office, Anakkayam, Anakkayam.P.O., - 676 509", "", "8547615819", "vo-anakkayam.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Areacode", "Village office, Areacode, Areacode.P.O.,- 673 639", "", "8547615813", "vo-areacode.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Chembrasseri", "Village office, Chembrasseri, Chembrasseri.P.O., 676 521", "", "8547615815", "vo-chembrasseri.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Edavanna", "Village office, Edavanna,Edavanna.P.O.- 676 541", "", "8547615807", "vo-edavanna.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Elankur", "Village office, Elankur, Elankur.P.O., 676 122", "", "8547615812", "vo-elankur.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Karakunnu", "Village office, Karakunnu,Karakunnu.P.O.- 676 123", "", "8547615806", "vo-karakunnu.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Kavanur", "Village office,Kavanur, Kavanur.P.O., 673 639", "", "8547615808", "vo-kavanur.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Kizhuparamba", "Village office, Kizhuparamba, Kizhuparamba.P.O - 673 639", "", "8547615828", "vo-kizhuparamba.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Malappuram", "Village office, Malappuram, Down Hill.P.O.- 676505", "", "8547615816", "vo-mpm.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Manjeri", "Village office, Manjeri,Manjeri.P.O.- 676 121", "", "8547615802", "vo-manjeri.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Melmuri", "Village office, Melmuri, Melmuri.P.O., 676517", "", "8547615817", "vo-melmuri.erd.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Narukara", "Village office, Narukara, Narukara.P.O, 676 122", "", "8547615804", "vo-narukara.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Panakkad", "Village office, Panakkad, Pattarkadavu.P.O., 676519", "", "8547615823", "vo-panakkad.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Pandallur", "Village office, Pandallur, Kadambode.P.O., - 676 521", "", "8547615820", "vo-pandallur.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Pandikkad", "Village office, Pandikkad, Pandikkad.P.O., - 676 521", "", "8547615814", "vo-pandikkad.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Payyanad", "Village office, Payyanad, Payyanad, P.O.- 676 122", "", "8547615803", "vo-payyanad.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Perakamanna", "Village office, Perakamanna, Pannippara.P.O.- 676 541", "", "8547615811", "vo-perakamanna.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Pookkottur", "Village office, Pookkottur, Valluvambram.P.O.,- 673 642", "", "8547615818", "vo-pookkottur.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Pulpatta", "Village office, Pulpatta, Pulpatta.P.O, - 676 123", "", "8547615809", "vo-pulpatta.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Trikkalangode", "Village office, Trikkalangode,Trikkalangode.P.O., 676 123", "", "8547615805", "vo-trikkalangode.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Urangattiri", "Village office, Urangattiri., Urangattiri.P.O - 673639", "", "8547615827", "vo-urangattiri.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Vettikattiri", "Village office, Vettikattiri, Pandikkad.P.O., - 676 521", "", "8547615810", "vo-vettikattiri.rev@kerala.gov.in");
            dbHelper.insertContact("Ernad", "Vettilappara", "Village office, Vettilappara, Vettilappara.P.O., - 673 639", "", "8547615834", "vo-vettilappara.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Aliparamba", "Village office, Aliparamba, Aliparamba-P.O. - 679357", "", "8547615713", "vo-aliparamba.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Anamangad", "Village office, Anamangad, Anamangad.P.O.- 679357", "", "8547615714", "vo-anamangad.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Angadippuram", "Village office, Angadippuram, Angadippuram.P.O., PIN .679321", "", "8547615715", "vo-angadippuram.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Arakkuparamba", "Village office, Arakkuparamba,Arakkuparamba .P.O., 679322", "", "8547615705", "vo-arakkuparamba.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Edappatta", "Village office, Edappatta, Edappatta.P.O., -679326", "", "8547615711", "vo-edappatta.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Elamkulam", "Village office, Elamkulam, Kunnakkavu.P.O., - 679340", "", "8547615712", "vo-elamkulam.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Karyavattam", "Village office, Karyavattam, Mannarmala.P.O.,- 679325", "", "8547615710", "vo-karyavattam.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Keezhattur", "Village office, Keezhattur, Pattikkad.P.O., - 679325", "", "8547615707", "vo-keezhattur.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Kodur", "Village office, Kodur, Kodur.P.O.- 676504", "", "8547615719", "vo-kodur.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Koottilangadi", "Village office, Koottilangadi, Padinhattumuri.P.O., - 676506", "", "8547615722", "vo-koottilangadi.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Kuruva", "Village office, Kuruva, Vattallur.P.O., - 676507", "", "8547615724", "vo-kuruva.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Kuruvambalam", "Village office, Kuruvambalam, Kuruvambalam.P.O., - 679338", "", "8547615721", "vo-kuruvambalam.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Mankada", "Village office, Mankada, Kadannamanna.P.O., 679324", "", "8547615718", "vo-mankada.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Melattur", "Village office, Melattur, Melattur.P.O., 679326", "", "8547615704", "vo-melattur.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Moorkkanad", "Village office, Moorkkanad, Kolathur.P.O., - 679338", "", "8547615723", "vo-moorkkanad.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Nenmini", "Village office, Nenmini,Tachinaganadam P.O., PIN.679325", "", "8547615708", "vo-nenmini.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Pathaikara", "Village office, Pathaikara,Eravimangalam .P.O., - 679340", "", "8547615703", "vo-pathaikara.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Perinthalmanna", "Village office, Perinthalmanna, Perinthalmanna P O,- 679322", "", "8547615702", "vo-perinthalmanna.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Pulamanthole", "Village office, Pulamanthole, Pulamanthole.P.O.,- 679323", "", "8547615720", "vo-pulamanthole.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Puzhakkattiri", "Village office, Puzhakkattiri, Puzhakkattiri.P.O., - 679321", "", "8547615725", "vo-puzhakkattiri.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Thazhekkode", "Village office, Thazhekkode, Thazhekkode West.P.O., - 679322", "", "8547615706", "vo-thazhekkode.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Vadakkanagara", "Village office, Vadakkanagara,Makkaraparamba.P.O.- 676507", "", "8547615717", "vo-vadakkanagara.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Valambur", "Village office, Valambur, Tirurkkad.P.O., PIN .679321", "", "8547615716", "vo-valambur.rev@kerala.gov.in");
            dbHelper.insertContact("Perinthalmanna", "Vettathur", "Village office, Vettathur, Vettathur.P.O., 679325", "", "8547615709", "vo-vettathur.rev@kerala.gov.in");
            dbHelper.insertContact("Ponnani", "Alamkode", "Village office,Alamkode, Nannamukku.P.O., - 679575", "", "8547615411", "vo-alamkode.rev@kerala.gov.in");


        }
    }

    public void call(View view) {
        List<Contact> contacts = dbHelper.getAllContact();
        for (Contact contact : contacts) {
            Toast.makeText(this, contact.getVillage(), Toast.LENGTH_SHORT).show();
        }
    }
}
